var flag = 0;
/** @View */
function downloadFile() {
	dorado.MessageBox.confirm("即将开始下载钳臂零件三维数模！确认继续？", function() {
		var armDrawingno = view.id("datagridTurretarm").getCurrentItem().get(
				"armDrawingno");
		var armDrawingnoMap = new dorado.util.Map();
		armDrawingnoMap.put("armDrawingno", armDrawingno);
		view.id("downloadDrawing").set("parameter", armDrawingnoMap).execute();
	});
}



/** @View */
//判断字符是否为空的方法
function isEmpty(obj){
  if(typeof obj == "undefined" || obj == null || obj == ""){
      return true;
  }else{
      return false;
  }
}


/**
 * RadioGroupImageType
 */
// @Bind #RadioGroupImageType.onClick
!function(self, arg) {
	var selectType = view.get("#autoformTurretarmImageType").get("entity").get(
			"autoformTurretarmImageTypeElement");

	switch (selectType) {
	case 'Cu':
		view.get("#image11").set("image", "images/2D/Cu/1-1.jpg");
		view.get("#image12").set("image", "images/2D/Cu/1-2.jpg");
		view.get("#image21").set("image", "images/2D/Cu/2-1.jpg");
		view.get("#image22").set("image", "images/2D/Cu/2-2.jpg");
		view.get("#image31").set("image", "images/2D/Cu/3-1.jpg");
		view.get("#image32").set("image", "images/2D/Cu/3-2.jpg");
		view.get("#image41").set("image", "images/2D/Cu/4-1.jpg");
		view.get("#image42").set("visible", true);
		view.get("#image42").set("image", "images/2D/Cu/4-2.jpg");
		view.get("#image51").set("visible", true);
		view.get("#image52").set("visible", true);
		view.get("#image51").set("image", "images/2D/Cu/5-1.jpg");
		view.get("#image52").set("image", "images/2D/Cu/5-2.jpg");
		break;
	case 'Al':
		view.get("#image11").set("image", "images/2D/Al/1-1.jpg");
		view.get("#image12").set("image", "images/2D/Al/1-2.jpg");
		view.get("#image21").set("image", "images/2D/Al/2-1.jpg");
		view.get("#image22").set("image", "images/2D/Al/2-2.jpg");
		view.get("#image31").set("image", "images/2D/Al/3-1.jpg");
		view.get("#image32").set("image", "images/2D/Al/3-2.jpg");
		view.get("#image41").set("image", "images/2D/Al/3-3.jpg");
		view.get("#image42").set("visible", false);
		view.get("#image51").set("image", "images/2D/Al/4-1.jpg");
		view.get("#image52").set("image", "images/2D/Al/4-2.jpg");
		break;
	default:
		break;
	}
};

/**
 * RadioGroupTypeCondition
 */
// @Bind #RadioGroupTypeCondition.onClick
!function(self, arg) {
	var armStandard = view.get("#autoformQueryForCondition").get("entity").get(
			"armStandard");
	var entity = view.get("#autoformTurretarm").get("entity").set(
			"armStandard", armStandard);
	view.get("#dataSetTurretarm").set("parameter", entity).flushAsync();

};

// 右键点击2D视图弹出选项
/*------------------------------------------------------------------------------------------------------*/
// @Bind #image11.onContextMenu
!function(self, arg, menuContext11) {
	menuContext11.show({
		position : {
			left : arg.event.pageX,
			top : arg.event.pageY
		}
	});
};
// @Bind #image12.onContextMenu
!function(self, arg, menuContext12) {
	menuContext12.show({
		position : {
			left : arg.event.pageX,
			top : arg.event.pageY
		}
	});
};
// @Bind #image21.onContextMenu
!function(self, arg, menuContext21) {
	menuContext21.show({
		position : {
			left : arg.event.pageX,
			top : arg.event.pageY
		}
	});
};
// @Bind #image22.onContextMenu
!function(self, arg, menuContext22) {
	menuContext22.show({
		position : {
			left : arg.event.pageX,
			top : arg.event.pageY
		}
	});
};
// @Bind #image31.onContextMenu
!function(self, arg, menuContext31) {
	menuContext31.show({
		position : {
			left : arg.event.pageX,
			top : arg.event.pageY
		}
	});
};
// @Bind #image32.onContextMenu
!function(self, arg, menuContext32) {
	menuContext32.show({
		position : {
			left : arg.event.pageX,
			top : arg.event.pageY
		}
	});
};
// @Bind #image41.onContextMenu
!function(self, arg, menuContext41) {
	menuContext41.show({
		position : {
			left : arg.event.pageX,
			top : arg.event.pageY
		}
	});
};
// @Bind #image42.onContextMenu
!function(self, arg, menuContext42) {
	menuContext42.show({
		position : {
			left : arg.event.pageX,
			top : arg.event.pageY
		}
	});
};
// @Bind #image51.onContextMenu
!function(self, arg, menuContext51) {
	menuContext51.show({
		position : {
			left : arg.event.pageX,
			top : arg.event.pageY
		}
	});
};
// @Bind #image52.onContextMenu
!function(self, arg, menuContext52) {
	menuContext52.show({
		position : {
			left : arg.event.pageX,
			top : arg.event.pageY
		}
	});
};
// @Bind #datagridTurretarm.onContextMenu
!function(self, arg, menuCheckTurretArmInfo) {
	menuCheckTurretArmInfo.show({
		position : {
			left : arg.event.pageX,
			top : arg.event.pageY
		}
	});
	
};
/*------------------------------------------------------------------------------------------------------*/
// @Bind #menuitemTurretInfo.onClick
!function(self, arg, dialogInfo, dialog2Dimage) {
	var armDrawingno = view.id("dataSetTurretarm").get("data:#").get("armDrawingno");
	var DrawingPath = "${servletContext.getAttribute('configprop').get('TURRETARM2D_PATH')}";
	if(armDrawingno){
		view.id("image2d").set("image",DrawingPath + armDrawingno+".jpg");
	}else{
		view.id("image2d").set("image",null);
	}
	
	dialogInfo.set("offsetLeft",-200);
	dialog2Dimage.set("offsetLeft",600);
	
	dialogInfo.show();
	dialog2Dimage.show();
};




/*-------------------------------------------------------------------------------------------------------*/
//表格中右键复制按钮
//@Bind #menuItemCopy.onClick
!function(self, arg, updateactionSave) {
	dorado.MessageBox.confirm("确认要复制该条记录吗？", function(){
		
		
		var entity = view.id("datagridTurretarm").getCurrentItem();
		var addedEntity = entity.createBrother(entity,false);
		var oldarmDrawingno = entity.get("armDrawingno");
		var newarmDrawingno = oldarmDrawingno.concat("_副本");
		
		addedEntity.set("armDrawingno",newarmDrawingno);
		var json = addedEntity.toJSON();
		
		view.id("updateactionSave").set("userData","flag");
		updateactionSave.execute();
	});
};


/*-------------------------------------------------------------------------------------------------------*/
// 根据2D视图进行快速查找
// @Bind #image11.onClick
// @Bind #menuitemQuery11.onClick
!function(self, arg) {
	var armType = view.get("#autoformTurretarmImageType").get("entity").get(
			"autoformTurretarmImageTypeElement");
	var entity = view.get("#autoformTurretarm").get("entity").set("armSerial",
			"1-1");
	var entity2 = view.get("#autoformTurretarm").get("entity").set("armType",
			armType);
	var entity3 = $.extend(entity, entity2);
	view.get("#dataSetTurretarm").set("parameter", entity3).flushAsync();
};
// @Bind #image12.onClick
// @Bind #menuitemQuery12.onClick
!function(self, arg) {
	var armType = view.get("#autoformTurretarmImageType").get("entity").get(
			"autoformTurretarmImageTypeElement");
	var entity = view.get("#autoformTurretarm").get("entity").set("armSerial",
			"1-2");
	var entity2 = view.get("#autoformTurretarm").get("entity").set("armType",
			armType);
	var entity3 = $.extend(entity, entity2);
	view.get("#dataSetTurretarm").set("parameter", entity3).flushAsync();
};
// @Bind #image21.onClick
// @Bind #menuitemQuery21.onClick
!function(self, arg) {
	var armType = view.get("#autoformTurretarmImageType").get("entity").get(
			"autoformTurretarmImageTypeElement");
	var entity = view.get("#autoformTurretarm").get("entity").set("armSerial",
			"2-1");
	var entity2 = view.get("#autoformTurretarm").get("entity").set("armType",
			armType);
	entity3 = $.extend(entity, entity2);
	view.get("#dataSetTurretarm").set("parameter", entity3).flushAsync();
};
// @Bind #image22.onClick
// @Bind #menuitemQuery22.onClick
!function(self, arg) {
	var armType = view.get("#autoformTurretarmImageType").get("entity").get(
			"autoformTurretarmImageTypeElement");
	var entity = view.get("#autoformTurretarm").get("entity").set("armSerial",
			"2-2");
	var entity2 = view.get("#autoformTurretarm").get("entity").set("armType",
			armType);
	entity3 = $.extend(entity, entity2);
	view.get("#dataSetTurretarm").set("parameter", entity3).flushAsync();
};
// @Bind #image31.onClick
// @Bind #menuitemQuery31.onClick
!function(self, arg) {
	var armType = view.get("#autoformTurretarmImageType").get("entity").get(
			"autoformTurretarmImageTypeElement");
	var entity = view.get("#autoformTurretarm").get("entity").set("armSerial",
			"3-1");
	var entity2 = view.get("#autoformTurretarm").get("entity").set("armType",
			armType);
	entity3 = $.extend(entity, entity2);
	view.get("#dataSetTurretarm").set("parameter", entity3).flushAsync();
};
// @Bind #image32.onClick
// @Bind #menuitemQuery32.onClick
!function(self, arg) {
	var armType = view.get("#autoformTurretarmImageType").get("entity").get(
			"autoformTurretarmImageTypeElement");
	var entity = view.get("#autoformTurretarm").get("entity").set("armSerial",
			"3-2");
	var entity2 = view.get("#autoformTurretarm").get("entity").set("armType",
			armType);
	entity3 = $.extend(entity, entity2);
	view.get("#dataSetTurretarm").set("parameter", entity3).flushAsync();
};
// @Bind #image41.onClick
// @Bind #menuitemQuery41.onClick
!function(self, arg) {
	var armType = view.get("#autoformTurretarmImageType").get("entity").get(
			"autoformTurretarmImageTypeElement");
	var entity = view.get("#autoformTurretarm").get("entity").set("armSerial",
			"4-1");
	var entity2 = view.get("#autoformTurretarm").get("entity").set("armType",
			armType);

	switch (armType) {
	case 'Cu':
		entity3 = $.extend(entity, entity2);
		view.get("#dataSetTurretarm").set("parameter", entity3).flushAsync();
		break;
	case 'Al':
		var entity = view.get("#autoformTurretarm").get("entity").set(
				"armSerial", "3-3");
		entity3 = $.extend(entity, entity2);
		view.get("#dataSetTurretarm").set("parameter", entity3).flushAsync();
		break;
	}

};
// @Bind #image42.onClick
// @Bind #menuitemQuery42.onClick
!function(self, arg) {
	var armType = view.get("#autoformTurretarmImageType").get("entity").get(
			"autoformTurretarmImageTypeElement");
	var entity = view.get("#autoformTurretarm").get("entity").set("armSerial",
			"4-2");
	var entity2 = view.get("#autoformTurretarm").get("entity").set("armType",
			armType);

	switch (armType) {
	case 'Cu':
		entity3 = $.extend(entity, entity2);
		view.get("#dataSetTurretarm").set("parameter", entity3).flushAsync();
		break;
	case 'Al':

		break;
	}
	;
};
// @Bind #image51.onClick
// @Bind #menuitemQuery51.onClick
!function(self, arg) {
	var armType = view.get("#autoformTurretarmImageType").get("entity").get(
			"autoformTurretarmImageTypeElement");
	var entity = view.get("#autoformTurretarm").get("entity").set("armSerial",
			"5-1");
	var entity2 = view.get("#autoformTurretarm").get("entity").set("armType",
			armType);

	switch (armType) {
	case 'Cu':
		entity3 = $.extend(entity, entity2);
		view.get("#dataSetTurretarm").set("parameter", entity3).flushAsync();
		break;
	case 'Al':
		var entity = view.get("#autoformTurretarm").get("entity").set(
				"armSerial", "4-1");
		entity3 = $.extend(entity, entity2);
		view.get("#dataSetTurretarm").set("parameter", entity3).flushAsync();
		break;
	/*
	 * default: var
	 * entity=view.get("#autoformTurretarm").get("entity").set("armType","Cu");
	 * view.get("#dataSetTurretarm").set("parameter",entity).flushAsync();
	 * break;
	 */
	}
	;
};
// @Bind #image52.onClick
// @Bind #menuitemQuery52.onClick
!function(self, arg) {
	var armType = view.get("#autoformTurretarmImageType").get("entity").get(
			"autoformTurretarmImageTypeElement");
	var entity = view.get("#autoformTurretarm").get("entity").set("armSerial",
			"5-2");
	var entity2 = view.get("#autoformTurretarm").get("entity").set("armType",
			armType);

	switch (armType) {
	case 'Cu':
		entity3 = $.extend(entity, entity2);
		view.get("#dataSetTurretarm").set("parameter", entity3).flushAsync();
		break;
	case 'Al':
		var entity = view.get("#autoformTurretarm").get("entity").set(
				"armSerial", "4-2");
		entity3 = $.extend(entity, entity2);
		view.get("#dataSetTurretarm").set("parameter", entity3).flushAsync();
		break;
	}
	;
};
/*----------------------------------------------------------------------------------------------------------------*/

/**
 * 514
 */
//@Bind #buttonUploadAttachedPage.onClick
!function() {
	if (view.id("dialogEdit").get("tags") == "Modify") {
		dorado.widget.NotifyTipManager.notify("确认修改重新上传工艺附属页？原始工艺附属页将被覆盖！");
	}
	var json = view.id("autoformTurretarmInfo").get("entity").toJSON();
	json["tag"] = "uploadAttachedPage";
	view.id("uploadAttachedPage").set("parameter", json).execute();
};


//@Bind #buttonUploadDrawing.onClick
!function() {
	if (view.id("dialogEdit").get("tags") == "Modify") {
		dorado.widget.NotifyTipManager.notify("确认修改重新上传数模文件？原始数模文件将被覆盖！");
	}
	var json = view.id("autoformTurretarmInfo").get("entity").toJSON();
	json["tag"] = "uploadDrawing";
	view.id("uploadDrawing").set("parameter", json).execute();
};

// 文件上传完成之后
// 未解决问题：文件上传失败之后，临时文件为处理
//@Bind #uploadAttachedPage.onFileUploaded
!function(self, arg) {
	
	var Value = arg.returnValue;
	
	var fileName = Value.fileName;
	var returnValue = Value.returnValue;
	var result = Value.result;

	if (returnValue == "E_Fail") {
		dorado.MessageBox.alert("上传失败，确保相关参数填写完整！");
		return;
	}
		dorado.MessageBox.alert("文件" + fileName + "成功上传");
		
	}


// @Bind #uploadDrawing.onFileUploaded
!function(self, arg) {
	
	var Value = arg.returnValue;
	
	var fileName = Value.fileName;
	var returnValue = Value.returnValue;
	var result = Value.result;
	
	if(result=="failed"){
		dorado.MessageBox.alert("上传文件名称与录入图号不符！",{title:"警告",icon:"WARNING"});
	}
	else{
		if (returnValue == "E_Fail") {
			dorado.MessageBox.alert("上传失败，确保相关参数填写完整！");
			return;
		}
		dorado.MessageBox.alert("文件" + fileName + "成功上传");
		};
	}
	
	

// @Bind #buttonUpload2DDrawing.onClick
!function() {
	if (view.id("dialogEdit").get("tags") == "Modify") {
		dorado.widget.NotifyTipManager.notify("确认修改重新上传二维图纸文件？原始二维图纸文件将被覆盖！");
	}
	var json = view.id("autoformTurretarmInfo").get("entity").toJSON();
	json["tag"] = "upload2DDrawing";
	view.id("upload2DDrawing").set("parameter", json).execute();
	
};

// 文件上传完成之后
// 未解决问题：文件上传失败之后，临时文件为处理
// @Bind #upload2DDrawing.onFileUploaded
!function(self, arg) {
	var Value = arg.returnValue;
	var returnValue = Value.returnValue;
	if (returnValue == "E_Fail") {
		dorado.MessageBox.alert("上传失败，确保相关参数填写完整！");
		return;
	}
	var fileName = Value.fileName;
	dorado.MessageBox.alert("文件" + fileName + "成功上传");
};

// @Bind #menuItemDownLoad3DFile.onClick
!function(self, downloadDrawing, datagridTurretarm) {
	dorado.MessageBox.confirm("确认下载三维数模？", function() {
		var armDrawingno = datagridTurretarm.getCurrentItem().get(
				"armDrawingno");
		var armDrawingnoMap = new dorado.util.Map();
		armDrawingnoMap.put("armDrawingno", armDrawingno);
		armDrawingnoMap.put("AttachedPageOrNot", "no");
		view.id("downloadDrawing").set("parameter", armDrawingnoMap).execute();
	});
};

//@Bind #menuItemDownLoadAttachedPage.onClick
!function(self, downloadDrawing, datagridTurretarm) {
	dorado.MessageBox.confirm("确认下载工艺附属页？", function() {
		var armDrawingno = datagridTurretarm.getCurrentItem().get(
				"armDrawingno");
		var armDrawingnoMap = new dorado.util.Map();
		armDrawingnoMap.put("armDrawingno", armDrawingno);
		armDrawingnoMap.put("AttachedPageOrNot", "yes");
		view.id("downloadDrawing").set("parameter", armDrawingnoMap).execute();
	});
};


// @Bind #menuItemOpen2DDrawing.onClick
!function(dialog2Dimage, image2d) {
	dorado.widget.NotifyTipManager.notify("正在为您打开二维图......!");
	var armDrawingno = view.id("dataSetTurretarm").get("data:#").get(
			"armDrawingno");
	var DrawingPath = "${servletContext.getAttribute('configprop').get('TURRETARM2D_PATH')}";
	if (armDrawingno) {
		// image2d.set("image",$url(">images/2D/"+armDrawingno+".jpg"));
		image2d.set("image", DrawingPath + armDrawingno + ".jpg");
	} else {
		image2d.set("image", null);
	}
	view.id("dialog2Dimage").set("offsetLeft",null);
	dialog2Dimage.show();
};



//@Bind #frame.onLoad
!function(self, arg) {
	if (flag > 0) {
		dorado.widget.NotifyTipManager.notify("File not Exist！文件不存在");
	}
	flag++;
};

// @Bind #frame.onCreate
!function(self, arg) {
	flag = 0;
};

// 只有当图号不为空时才能进行上传或者保存等操作
// @Bind #autoformTurretarmInfo.#armDrawingno.onBlur
!function(buttonSaveInfo,self,arg,buttonUploadDrawing,buttonUpload2DDrawing) {
	
	var eleValue = self.get("value");
	if(!view.isEmpty(eleValue)) {
		buttonSaveInfo.set("disabled",false);
		buttonUpload2DDrawing.set("disabled",false);
		buttonUploadDrawing.set("disabled",false);
	}else {
		buttonSaveInfo.set("disabled",true);
		buttonUpload2DDrawing.set("disabled",true);
		buttonUploadDrawing.set("disabled",true);
	}
};


//@Bind #updateactionSave.onSuccess
!function(self, arg, ajaxActionJudgeStringIsSatisfied) {
	var flag = view.id("updateactionSave").get("userData");
	if (isEmpty(flag)) {
		ajaxActionJudgeStringIsSatisfied.set("parameter",
			view.id("autoformTurretarmInfo").get("entity").toJSON()).execute();
	}
};

// @Bind #ajaxActionJudgeStringIsSatisfied.onSuccess
!function(self, updateactionSave) {
	var returnValue = self.get("returnValue");
	if (returnValue.flag == "S_OK") {
		dorado.widget.NotifyTipManager.notify("添加完成......!");
		view.id("dialogEdit").hide();
	} else {
		dorado.MessageBox.alert(returnValue.flag);
	}
};

//@Bind #ajaxActionDeleteRelatedFiles.onSuccess
!function(self, arg) {
	dorado.widget.NotifyTipManager.notify(self.get("returnValue"));
};

//@Bind #datagridTurretarm.#armDrawingno.onRenderCell
!function(arg) {
	var armDrawingno = arg.data.get("armDrawingno");
	arg.dom.innerHTML = "<a href='javascript:view.downloadFile()'>"+armDrawingno+"</a>";
};


//@Bind #datagridTurretarm.#armCode.onRenderCell
!function(arg) {
	// arg.dom.style.background = (arg.data.get("armassemblyCode") > 3000) ?
	// "#fcc5c5" : "";
	arg.dom.style.background = "#FFD39B";
	arg.dom.style.color = "red";
	var armCode = arg.data.get("armCode");
	// arg.dom.innerHTML = "<a
	// href='com.nimak.viewsets.TurretInfoManage.d'>"+armassemblyCode+"</a>";
	arg.processDefault = true;
};

/*----------------------------------------------------------------------------------------------------------------*/
// @Bind #textEditorLinearGuide.onReady
!function(self) {
	// 例如对于一个以数值型表示性别的属性，我们可能希望在显示属性值时将1显示为"男"、将0显示为"女"。
	self.set("mapping", [
	    {
	        key : 1,
	        value : "是"
	    },
	    {
	        key : 0,
	        value : "否"
	    }
	]);
};

//@Bind #textEditorarmStandard.onReady
!function(self) {
	// 例如对于一个以数值型表示性别的属性，我们可能希望在显示属性值时将1显示为"男"、将0显示为"女"。
	self.set("mapping", [
	    {
	        key : 1,
	        value : "标准零件"
	    },
	    {
	        key : 2,
	        value : "实例零件"
	    },
	    {
	        key : 3,
	        value : "典型零件"
	    }
	]);
};

	
/*----------------------------------------------------------------------------------------------------------------*/


// @Bind #autoformTurretarmInfo.#armMaterial.onBlur
!function(self) {
	var eleValue = self.get("value");
	if(!view.isEmpty(eleValue)) {
		if(eleValue === "Φ54/CuCr1Zr") {
			view.id("autoformTurretarmInfoarmSerial").set("trigger","listdropdownCuSerial");
		}else {
			view.id("autoformTurretarmInfoarmSerial").set("trigger","listdropdownAlSerial");
		}
	}	
};

//@Bind #autoformTurretarmInfo.#armDrawingno.onBlur
!function(self,ajaxActionVarifyDrawingno,dialogEdit) {
	var eleValue = self.get("value");
	if(dialogEdit.get("tags")=="Modify"){
		}
	if(dialogEdit.get("tags")=="Add"){
		ajaxActionVarifyDrawingno.set("parameter",eleValue).execute();
	}
	//dialogEdit.set("tags", "Modify");
	
	
	/*var armType=String(view.id("autoformTurretarmInfo").get("entity").get("armType"));

	switch(armType){
		case 'Cu':
		break;
		case 'Al':
		break;
		case '其他':
		break;
		default:
			var eleValue = self.get("value");
			ajaxActionVarifyDrawingno.set("parameter",eleValue).execute();
		break;
	}*/
};




//@Bind #datagridTurretarm.onReady 
!function(self,tipDataGrid) {
	dorado.TipManager.initTip(self.getDom(), {
		text : self.get("tip"),
		icon: "QUESTION",
		trackMouse: true
	});
};
