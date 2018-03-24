
/**
 * RadioGroupType
 */
//@Bind #RadioGroupType.onClick
!function(self,arg){
	
	view.get("#autoformTurretarm").get("entity").set("armLength1",null);
	view.get("#autoformTurretarm").get("entity").set("armLength2",null);
	var selectType = view.get("#autoformTurretarm").get("entity").get("armType");
	
	switch(selectType){
		case 'Cu':
			view.get("#armLength1").set("trigger","listdropdownArmLength1Cu");
			view.get("#armLength2").set("trigger","listdropdownArmLength2Cu");
			
			view.get("#image11").set("image","images/2D/Cu/1-1.jpg");
			view.get("#image12").set("image","images/2D/Cu/1-2.jpg");
			view.get("#image21").set("image","images/2D/Cu/2-1.jpg");
			view.get("#image22").set("image","images/2D/Cu/2-2.jpg");
			view.get("#image31").set("image","images/2D/Cu/3-1.jpg");
			view.get("#image32").set("image","images/2D/Cu/3-2.jpg");
			view.get("#image33").set("visible",false);
			view.get("#image41").set("image","images/2D/Cu/4-1.jpg");
			view.get("#image42").set("image","images/2D/Cu/4-2.jpg");
			view.get("#image51").set("visible",true);
			view.get("#image52").set("visible",true);
			view.get("#image51").set("image","images/2D/Cu/5-1.jpg");
			view.get("#image52").set("image","images/2D/Cu/5-2.jpg");
		break;
		case 'Al':
			view.get("#armLength1").set("trigger","listdropdownArmLength1Al");
			view.get("#armLength2").set("trigger","listdropdownArmLength2Al");
			
			view.get("#image11").set("image","images/2D/Al/1-1.jpg");
			view.get("#image12").set("image","images/2D/Al/1-2.jpg");
			view.get("#image21").set("image","images/2D/Al/2-1.jpg");
			view.get("#image22").set("image","images/2D/Al/2-2.jpg");
			view.get("#image31").set("image","images/2D/Al/3-1.jpg");
			view.get("#image32").set("image","images/2D/Al/3-2.jpg");
			view.get("#image33").set("visible",true);
			view.get("#image33").set("image","images/2D/Al/3-3.jpg");
			view.get("#image41").set("image","images/2D/Al/4-1.jpg");
			view.get("#image42").set("image","images/2D/Al/4-2.jpg");
			view.get("#image51").set("visible",false);
		    view.get("#image52").set("visible",false);
		break;
		default:
			view.get("#armLength1").set("trigger","listdropdownArmLengthOthers");
			view.get("#armLength2").set("trigger","listdropdownArmLengthOthers");
		break;
	}
};


/**
 * RadioGroupTypeCondition
 */
//@Bind #RadioGroupTypeCondition.onClick
!function(self,arg){
	
	var entity=view.get("#autoformQueryForCondition").get("entity");
	var entity2= view.get("#autoformTurretarm").get("entity");
	
	if(JSON.stringify(entity2) !== "{}"){
		entity3 = $.extend(entity, entity2);
		view.get("#dataSetTurretarm").set("parameter",entity3).flushAsync();
	}else{
		view.get("#dataSetTurretarm").set("parameter",entity).flushAsync();
	}
	
};


//右键点击2D视图弹出选项
/*------------------------------------------------------------------------------------------------------*/
//@Bind #image11.onContextMenu
!function(self, arg, menuContext11) {
	menuContext11.show({
		position : {
			left : arg.event.pageX,
			top : arg.event.pageY
		}
	});
};
//@Bind #image12.onContextMenu
!function(self, arg, menuContext12) {
	menuContext12.show({
		position : {
			left : arg.event.pageX,
			top : arg.event.pageY
		}
	});
};
//@Bind #image21.onContextMenu
!function(self, arg, menuContext21) {
	menuContext21.show({
		position : {
			left : arg.event.pageX,
			top : arg.event.pageY
		}
	});
};
//@Bind #image22.onContextMenu
!function(self, arg, menuContext22) {
	menuContext22.show({
		position : {
			left : arg.event.pageX,
			top : arg.event.pageY
		}
	});
};
//@Bind #image31.onContextMenu
!function(self, arg, menuContext31) {
	menuContext31.show({
		position : {
			left : arg.event.pageX,
			top : arg.event.pageY
		}
	});
};
//@Bind #image32.onContextMenu
!function(self, arg, menuContext32) {
	menuContext32.show({
		position : {
			left : arg.event.pageX,
			top : arg.event.pageY
		}
	});
};
//@Bind #image33.onContextMenu
!function(self, arg, menuContext33) {
	menuContext33.show({
		position : {
			left : arg.event.pageX,
			top : arg.event.pageY
		}
	});
};
//@Bind #image41.onContextMenu
!function(self, arg, menuContext41) {
	menuContext41.show({
		position : {
			left : arg.event.pageX,
			top : arg.event.pageY
		}
	});
};
//@Bind #image42.onContextMenu
!function(self, arg, menuContext42) {
	menuContext42.show({
		position : {
			left : arg.event.pageX,
			top : arg.event.pageY
		}
	});
};
//@Bind #image51.onContextMenu
!function(self, arg, menuContext51) {
	menuContext51.show({
		position : {
			left : arg.event.pageX,
			top : arg.event.pageY
		}
	});
};
//@Bind #image52.onContextMenu
!function(self, arg, menuContext52) {
	menuContext52.show({
		position : {
			left : arg.event.pageX,
			top : arg.event.pageY
		}
	});
};
/*------------------------------------------------------------------------------------------------------*/


/*-------------------------------------------------------------------------------------------------------*/
//根据2D视图进行快速查找
//@Bind #menuitemQuery11.onClick
// @Bind #image11.onClick
!function(self, arg) {
	var entity=view.get("#autoformTurretarm").get("entity").set("armSerial","1-1");
	view.get("#dataSetTurretarm").set("parameter",entity).flushAsync();
};
//@Bind #menuitemQuery12.onClick
// @Bind #image12.onClick
!function(self, arg) {
	var entity=view.get("#autoformTurretarm").get("entity").set("armSerial","1-2");
	view.get("#dataSetTurretarm").set("parameter",entity).flushAsync();
};
//@Bind #menuitemQuery21.onClick
// @Bind #image11.onClick
!function(self, arg) {
	var entity=view.get("#autoformTurretarm").get("entity").set("armSerial","2-1");
	view.get("#dataSetTurretarm").set("parameter",entity).flushAsync();
};
//@Bind #menuitemQuery22.onClick
!function(self, arg) {
	var entity=view.get("#autoformTurretarm").get("entity").set("armSerial","2-2");
	view.get("#dataSetTurretarm").set("parameter",entity).flushAsync();
};
//@Bind #menuitemQuery31.onClick
!function(self, arg) {
	var entity=view.get("#autoformTurretarm").get("entity").set("armSerial","3-1");
	view.get("#dataSetTurretarm").set("parameter",entity).flushAsync();
};
//@Bind #menuitemQuery32.onClick
!function(self, arg) {
	var entity=view.get("#autoformTurretarm").get("entity").set("armSerial","3-2");
	view.get("#dataSetTurretarm").set("parameter",entity).flushAsync();
};
//@Bind #menuitemQuery33.onClick
!function(self, arg) {
	var entity=view.get("#autoformTurretarm").get("entity").set("armSerial","3-3");
	view.get("#dataSetTurretarm").set("parameter",entity).flushAsync();
};
//@Bind #menuitemQuery41.onClick
!function(self, arg) {
	var entity=view.get("#autoformTurretarm").get("entity").set("armSerial","4-1");
	view.get("#dataSetTurretarm").set("parameter",entity).flushAsync();
};
//@Bind #menuitemQuery42.onClick
!function(self, arg) {
	var entity=view.get("#autoformTurretarm").get("entity").set("armSerial","4-2");
	view.get("#dataSetTurretarm").set("parameter",entity).flushAsync();
};
//@Bind #menuitemQuery51.onClick
!function(self, arg) {
	var entity=view.get("#autoformTurretarm").get("entity").set("armSerial","5-1");
	view.get("#dataSetTurretarm").set("parameter",entity).flushAsync();
};
//@Bind #menuitemQuery52.onClick
!function(self, arg) {
	var entity=view.get("#autoformTurretarm").get("entity").set("armSerial","5-2");
	view.get("#dataSetTurretarm").set("parameter",entity).flushAsync();
};
/*--------------------------------------------------------------------------------------------------------*/