function connected(context, width, height) {
	var NUM_POINTS = 25;

	var points = [], intsy;

	var gravity = .15;
	var wind = .0;

	var emitter = {
		x : randBtwn(0, width),
		y : randBtwn(0, height)
	};

	function randBtwn(min, max) {
		return min + (max - min) * Math.random();
	}

	function resetPoint(p) {
		p.x = emitter.x + randBtwn(0, 200);
		p.y = emitter.y + randBtwn(0, 200);
		p.vY = randBtwn(-height / 300, height / 300);
		p.vX = randBtwn(-width / 300, width / 300);
		p.rgb = parseInt(randBtwn(0, 235)) + ", " + parseInt(randBtwn(0, 235)) + ", " + parseInt(randBtwn(0, 235));
		p.radius = randBtwn(3, 25);
	}

	function initPoint() {
		var p = {};
		resetPoint(p);
		return p;
	}

	function addPoint() {
		if (points.length < NUM_POINTS)
			points.push(initPoint());
	}

	var MAX_DIST_2 = 100 * 100;
	var circRadius = 4;// pix
	function draw() {
		context.clearRect(0, 0, width, height);
		var point, i, j, ptCons = new Array(points.length);

		for (i = 0; i < points.length; i++) {
			ptCons[i] = new Array(points.length);

			for (j = 0; j < points.length; j++) {
				ptCons[i][j] = 0;
			}
		}

		for (i = 0; i < points.length; i++) {
			point = points[i];

			var min_dist_2 = MAX_DIST_2;

			context.beginPath();

			points.each(function(pt, j) {
				var dist_2 = (Math.pow(pt.x - point.x, 2) + Math.pow(pt.y
						- point.y, 2));

				if (dist_2 < min_dist_2 && pt != point)
					min_dist_2 = dist_2;

				if (pt == point || dist_2 > MAX_DIST_2 || ptCons[i][j])
					return;

				context.moveTo(point.x, point.y);
				var dirx = point.x > pt.x ? point.x : pt.x;
				var diry = point.y < pt.y ? point.y : pt.y;
				context.quadraticCurveTo(dirx, diry, pt.x, pt.y);
				context.strokeStyle = 'rgba(0,0,0,' + (1 - dist_2 / MAX_DIST_2)
						+ ' )'
				ptCons[i][j] = 1;
				ptCons[j][i] = 1;
			});
			context.stroke();

			context.beginPath();
			context.arc(point.x, point.y, point.radius, 0, 2 * Math.PI);
			context.fillStyle = 'rgba(' + point.rgb + ',.95)'
			context.fill();
		}

	}

	function print(arr) {
		var str = '';
		for ( var i = 0; i < arr.length; i++) {
			str = '';
			for ( var j = 0; j < arr[i].length; j++) {
				str += arr[i][j] + ", ";
			}
		}
	}

	function move(t) {
		points.each(function(point) {
			point.x = (point.x + point.vX) % width;
			point.y = (point.y + point.vY) % height;

			if (point.x < 0)
				point.x = width;

			if (point.y < 0)
				point.y = height;

		});
	}

	return {
		'start' : function() {
			var start = new Date();
			points = [];

			window.clearInterval(intsy);
			intsy = window.setInterval(function() {
				var startFrame = new Date();
				addPoint();
				move(new Date() - start);
				draw();
			}, 1000 / 30);
		},
		'stop' : function() {
			window.clearInterval(intsy);
		}
	}
}

var connected;

// @Bind view.onReady
!function(canvas) {
	//connected = connected(canvas.getContext("2d"), parseInt(canvas.get("width")), parseInt(canvas.get("height")));
	connected = connected(canvas.getContext("2d"), parseInt(document.body.clientWidth), parseInt(document.body.clientHeight));
	connected.start();
}

//@Bind #buttonStart.onClick
!function(buttonStart, buttonStop) {
	connected.start();
	buttonStart.set("disabled", true);
	buttonStop.set("disabled", false);
}

//@Bind #buttonStop.onClick
!function(buttonStart, buttonStop) {
	connected.stop();
	buttonStart.set("disabled", false);
	buttonStop.set("disabled", true);
}