var flag = 0;
/** @View */
function downloadFile() {
	dorado.MessageBox.confirm("即将开始下载电极握杆三维数模！确认继续？", function() {
		var shankDrawingno = view.id("datagridShank").getCurrentItem().get(
				"shankDrawingno");
		var shankDrawingnoMap = new dorado.util.Map();
		shankDrawingnoMap.put("shankDrawingno", shankDrawingno);
		view.id("downloadDrawing").set("parameter", shankDrawingnoMap)
				.execute();
	});
}

// @Bind #view.onCreate
!function(self, arg) {
	dorado.useObjectShim = true;
	view.$onMathTriggerExecute = function(self, arg) {
		var n = arg.editor.get("value");
		// n = eval(n + self.get("userData"));
		if (n == null || n == "") {
			return;
		}
		// 没有点击后面的trigger
		if (n.indexOf("折弯") == -1 && n.indexOf("机加") == -1) {
			n = n + self.get("userData");
		}
		var flag = self.get("userData");
		// 点击时，字符串中已有【】
		if (n.indexOf("[") != -1) {
			n = n.substring(0, n.indexOf("[")) + flag;
		}

		arg.editor.set("value", n);
		// view.id("autoformTurretComOrPartInfo2").get("entity").set("shankAngel1",n);
	};
};

// @Bind #dataSet1.onCreate
!function(self, arg) {
	self.clear();
	self.insert();
};

// @Bind #dsHolder.onCreate
!function(self, arg) {
	// self.insert();
};

// @Bind #buttonReset.onClick
// 条件查询重置按钮相应
!function(autoformCondition) {
	autoformCondition.get("entity").clearData();
};

// @Bind #buttonCloseDrawing.onClick
!function(dialog2DDrawing) {
	dialog2DDrawing.hide();
};

// @Bind #ButtonQuery.onClick
// @Bind #buttonQuery.onClick
// 条件查询查询按钮相应
!function(self, autoformCondition, dsHolder) {
	// 获取autoformCondition绑定的实体对象
	var entityJson = autoformCondition.get("entity").toJSON();
	dsHolder.set("parameter", entityJson).flushAsync();

	// 自动填充下拉框==ShankDrawingno===============================================================
	var newItem = autoformCondition.get("entity").get("shankDrawingno");
	var items = new Array();
	var object = view.id("listDropDownShankDrawingno").get("items");
	if (object != null) {
		items = Object.values(object);
	}
	// 数组首位添加元素
	if (newItem != null && newItem != "") {
		// 循环遍历元素，如果新添加的元素已经在下拉表中，将原始下拉表中该元素删除。
		for ( var i in items) {
			if (newItem == items[i]) {
				items.remove(items[i]);
			}
		}
		items.unshift(newItem);
	}
	// 下拉框设置为6各元素
	if (items.length > 6) {
		items.pop();
	}
	view.id("listDropDownShankDrawingno").set("items", items);
	view.id("shankDrawingnoForm").set("trigger", "listDropDownShankDrawingno");
	// ==================================================================================

	// 自动填充下拉框==shankCodeForm===============================================================
	var newItemShankCode = autoformCondition.get("entity").get("shankCode");
	var itemsShankCode = new Array();
	var objectWidth = view.id("listDropDownShankCode").get("items");
	if (objectWidth != null) {
		itemsShankCode = Object.values(objectWidth);
	}
	// 数组首位添加元素
	if (newItemShankCode != null && newItemShankCode != "") {
		// 循环遍历元素，如果新添加的元素已经在下拉表中，将原始下拉表中该元素删除。
		for ( var i in itemsShankCode) {
			if (newItemShankCode == itemsShankCode[i]) {
				itemsShankCode.remove(itemsShankCode[i]);
			}
		}
		itemsShankCode.unshift(newItemShankCode);
	}
	// 下拉框设置为6各元素
	if (itemsShankCode.length > 6) {
		itemsShankCode.pop();
	}
	view.id("listDropDownShankCode").set("items", itemsShankCode);
	view.id("shankCodeForm").set("trigger", "listDropDownShankCode");
	// ==================================================================================

	// 自动填充下拉框==shankMaterialForm===============================================================
	var newItemShankMaterial = autoformCondition.get("entity").get(
			"shankMaterial");
	var itemsShankMaterial = new Array();
	var objectLength = view.id("listDropDownShankMaterial").get("items");
	if (objectLength != null) {
		itemsShankMaterial = Object.values(objectLength);
	}
	// 数组首位添加元素
	if (newItemShankMaterial != null && newItemShankMaterial != "") {
		// 循环遍历元素，如果新添加的元素已经在下拉表中，将原始下拉表中该元素删除。
		for ( var i in itemsShankMaterial) {
			if (newItemShankMaterial == itemsShankMaterial[i]) {
				itemsShankMaterial.remove(itemsShankMaterial[i]);
			}
		}
		itemsShankMaterial.unshift(newItemShankMaterial);
	}
	// 下拉框设置为6各元素
	if (itemsShankMaterial.length > 6) {
		itemsShankMaterial.pop();
	}
	view.id("listDropDownShankMaterial").set("items", itemsShankMaterial);
	view.id("shankMaterialForm").set("trigger", "listDropDownShankMaterial");
	// ==================================================================================

	/*
	 * //
	 * 自动填充下拉框==shankTaper===============================================================
	 * var newItemShankTaper =
	 * autoformCondition.get("entity").get("shankTaper"); var itemsShankTaper =
	 * new Array(); var objectForce=
	 * view.id("listDropDownShankTaper").get("items"); if(objectForce != null){
	 * itemsShankTaper = Object.values(objectForce); } // 数组首位添加元素 if
	 * (newItemShankTaper != null && newItemShankTaper != "") { //
	 * 循环遍历元素，如果新添加的元素已经在下拉表中，将原始下拉表中该元素删除。 for(var i in itemsShankTaper) {
	 * if(newItemShankTaper == itemsShankTaper[i]) {
	 * itemsShankTaper.remove(itemsShankTaper[i]); } }
	 * itemsShankTaper.unshift(newItemShankTaper); } // 下拉框设置为6各元素 if
	 * (itemsShankTaper.length > 6) { itemsShankTaper.pop(); }
	 * view.id("listDropDownShankTaper").set("items",itemsShankTaper);
	 * view.id("shankTaperForm").set("trigger","listDropDownShankTaper");
	 * //==================================================================================
	 * 
	 *  //
	 * 自动填充下拉框==shankType===============================================================
	 * var newItemShankType = autoformCondition.get("entity").get("shankType");
	 * var itemsShankType = new Array(); var objectCapAngel=
	 * view.id("listDropDownShankType").get("items"); if(objectCapAngel !=
	 * null){ itemsShankType = Object.values(objectCapAngel); } // 数组首位添加元素 if
	 * (newItemShankType != null && newItemShankType != "") { //
	 * 循环遍历元素，如果新添加的元素已经在下拉表中，将原始下拉表中该元素删除。 for(var i in itemsShankType) {
	 * if(newItemShankType == itemsShankType[i]) {
	 * itemsShankType.remove(itemsShankType[i]); } }
	 * itemsShankType.unshift(newItemShankType); } // 下拉框设置为6各元素 if
	 * (itemsShankType.length > 6) { itemsShankType.pop(); }
	 * view.id("listDropDownShankType").set("items",itemsShankType);
	 * view.id("shankTypeForm").set("trigger","listDropDownShankType");
	 */
	// ==================================================================================

	// 自动填充下拉框==shankAngel1===============================================================
	var newItemShankAngel1 = autoformCondition.get("entity").get("shankAngel1");
	var itemsShankAngel1 = new Array();
	var objectCode = view.id("listDropDownShankAngel1").get("items");
	if (objectCode != null) {
		itemsShankAngel1 = Object.values(objectCode);
	}
	// 数组首位添加元素
	if (newItemShankAngel1 != null && newItemShankAngel1 != "") {
		// 循环遍历元素，如果新添加的元素已经在下拉表中，将原始下拉表中该元素删除。
		for ( var i in itemsShankAngel1) {
			if (newItemShankAngel1 == itemsShankAngel1[i]) {
				itemsShankAngel1.remove(itemsShankAngel1[i]);
			}
		}
		itemsShankAngel1.unshift(newItemShankAngel1);
	}
	// 下拉框设置为6各元素
	if (itemsShankAngel1.length > 6) {
		itemsShankAngel1.pop();
	}
	view.id("listDropDownShankAngel1").set("items", itemsShankAngel1);
	var triggers1 = new Array();
	triggers1.push("trigger1");
	triggers1.push("trigger2");
	triggers1.push("listDropDownShankAngel1");
	view.id("shankAngel1Form").set("trigger", triggers1);
	// ==================================================================================

	// 自动填充下拉框==shankAngel2===============================================================
	var newItemShankAngel2 = autoformCondition.get("entity").get("shankAngel2");
	var itemsShankAngel2 = new Array();
	var objectCode2 = view.id("listDropDownShankAngel2").get("items");
	if (objectCode2 != null) {
		itemsShankAngel2 = Object.values(objectCode2);
	}
	// 数组首位添加元素
	if (newItemShankAngel2 != null && newItemShankAngel2 != "") {
		// 循环遍历元素，如果新添加的元素已经在下拉表中，将原始下拉表中该元素删除。
		for ( var i in itemsShankAngel2) {
			if (newItemShankAngel2 == itemsShankAngel2[i]) {
				itemsShankAngel2.remove(itemsShankAngel2[i]);
			}
		}
		itemsShankAngel2.unshift(newItemShankAngel2);
	}
	// 下拉框设置为6各元素
	if (itemsShankAngel2.length > 6) {
		itemsShankAngel2.pop();
	}
	view.id("listDropDownShankAngel2").set("items", itemsShankAngel2);
	var triggers2 = new Array();
	triggers2.push("trigger1");
	triggers2.push("trigger2");
	triggers2.push("listDropDownShankAngel2");
	view.id("shankAngel2Form").set("trigger", triggers2);
	// ==================================================================================

	// 自动填充下拉框==shankAngel3===============================================================
	var newItemShankAngel3 = autoformCondition.get("entity").get("shankAngel3");
	var itemsShankAngel3 = new Array();
	var objectCode3 = view.id("listDropDownShankAngel3").get("items");
	if (objectCode3 != null) {
		itemsShankAngel3 = Object.values(objectCode3);
	}
	// 数组首位添加元素
	if (newItemShankAngel3 != null && newItemShankAngel3 != "") {
		// 循环遍历元素，如果新添加的元素已经在下拉表中，将原始下拉表中该元素删除。
		for ( var i in itemsShankAngel3) {
			if (newItemShankAngel3 == itemsShankAngel3[i]) {
				itemsShankAngel3.remove(itemsShankAngel3[i]);
			}
		}
		itemsShankAngel3.unshift(newItemShankAngel3);
	}
	// 下拉框设置为6各元素
	if (itemsShankAngel3.length > 6) {
		itemsShankAngel3.pop();
	}
	view.id("listDropDownShankAngel3").set("items", itemsShankAngel3);
	var triggers = new Array();
	triggers.push("trigger1");
	triggers.push("trigger2");
	triggers.push("listDropDownShankAngel3");
	/*
	 * view.id("shankAngel3Form").set("trigger","trigger1");
	 * view.id("shankAngel3Form").set("trigger","trigger2");
	 */
	view.id("shankAngel3Form").set("trigger", triggers);
	// ==================================================================================

	// 自动填充下拉框==shankDesigner===============================================================
	var newItemShankDesigner = autoformCondition.get("entity").get(
			"shankDesigner");
	var itemsShankDesigner = new Array();
	var objectShankDesigner = view.id("listDropDownShankDesigner").get("items");
	if (objectShankDesigner != null) {
		itemsShankDesigner = Object.values(objectShankDesigner);
	}
	// 数组首位添加元素
	if (newItemShankDesigner != null && newItemShankDesigner != "") {
		// 循环遍历元素，如果新添加的元素已经在下拉表中，将原始下拉表中该元素删除。
		for ( var i in itemsShankDesigner) {
			if (newItemShankDesigner == itemsShankDesigner[i]) {
				itemsShankDesigner.remove(itemsShankDesigner[i]);
			}
		}
		itemsShankDesigner.unshift(newItemShankDesigner);
	}
	// 下拉框设置为6各元素
	if (itemsShankDesigner.length > 6) {
		itemsShankDesigner.pop();
	}
	view.id("listDropDownShankDesigner").set("items", itemsShankDesigner);
	view.id("shankDesignerForm").set("trigger", "listDropDownShankDesigner");
	// ==================================================================================

};

/*
 * if(!self.get("data").getLast()) {
 * //dorado.MessageBox.alert("没有找到满足条件的设计，请重新限定条件查询...");
 * dorado.widget.NotifyTipManager.notify("没有找到满足条件的设计，请重新限定条件查询..."); }
 */

// @Bind #buttonAdd.onClick
// @Bind #buttonAddInToolbar.onClick
!function(self, arg, dialogEditShank, dsHolder, autoformAdd, uploadFileTipLabel) {
	// id设置为自动加1
	/*
	 * var aa = new Array(); aa = dsHolder.get("data"); var temp = new Array();
	 * var i=1,num=0; aa.each(function(entity){ temp.push(entity.get("id"));
	 * i++; }); num = Math.max.apply(null,temp)+1;
	 */
	// console.log(num);
	view.id("updateactionSave").set("userData",null);
	dsHolder.insert();
	// autoformAdd.get("entity").set("id",num);
	dialogEditShank.show();
	dialogEditShank.set("tags", "Add");
	uploadFileTipLabel.set("visible", false);
	
	
	view.id("buttonSave1").set("disabled",true);
	view.id("buttonUpload2DDrawing").set("disabled",true);
	view.id("buttonUploadDrawing").set("disabled",true);
	
};

// @Bind #buttonCancel1.onClick
!function(self, dsHolder, dialogEditShank) {
	// 如果是修改：
	if (dialogEditShank.get("tags") == "Modify") {
		dsHolder.get("data:#").cancel();
		view.id("updateactionSave").set("userData",null);
		dialogEditShank.hide();
	}
	// 如果是添加：
	if (dialogEditShank.get("tags") == "Add") {
		var entity = dsHolder.get("data:#");
		entity.remove();
		view.id("updateactionSave").set("userData","flag");
		view.id("updateactionSave").execute();
		dialogEditShank.hide();
	}

};

/*
 * // @Bind #buttonSave1.onClick !function(self, autoformAdd,
 * ajaxActionJudgeStringIsSatisfied) {
 * ajaxActionJudgeStringIsSatisfied.set("parameter",
 * autoformAdd.get("entity").toJSON()).execute(); };
 *  // @Bind #ajaxActionJudgeStringIsSatisfied.onSuccess !function(self,
 * updateactionSave) { var returnValue = self.get("returnValue"); if
 * (returnValue.flag == "S_OK") { var codeValue = returnValue.coderesult;
 * view.id("autoformAdd").get("entity").set("shankCode",codeValue);
 * view.id("autoFormBasicAttr").get("entity").set("shankCode",codeValue);
 * 
 * updateactionSave.execute(); } else { if(returnValue.flag.indexOf("编码") != -1) {
 * dorado.MessageBox.confirm(returnValue.flag+"是否继续保存？", function() {
 * view.id("autoformAdd").get("entity").set("shankCode","");
 * view.id("autoFormBasicAttr").get("entity").set("shankCode","");
 * updateactionSave.execute(); }); } else {
 * dorado.MessageBox.alert(returnValue.flag); } return; } };
 * 
 * //@Bind #updateactionSave.onSuccess !function(self, dialogEditShank) { //
 * 如果成功 dialogEditShank.hide(); };
 */

// @Bind #buttonSave1.onClick
!function(self, ajaxActionCode) {
	// 先去编码
	var entity = view.id("autoformAdd").get("entity");
	var angle1 = entity.get("shankAngel1");
	var angle2 = entity.get("shankAngel2");
	var angle3 = entity.get("shankAngel3");

	var pattern = /^[0-9]+([.]{1}[0-9]+){0,1}(\[[\u2E80-\u9FFF]+\]){1}$/;

	if (typeof angle1 !== 'undefined') {
		if (angle1 == "0[折弯获得]" || angle1 == "0[机加获得]") {
			dorado.MessageBox.alert("旋转角度1_输入格式有误！[0,无,输入角度后选择偏移生成方式]");
			return;
		}
		if (angle1 != "无" && angle1 != "0" && !pattern.exec(angle1)) {
			dorado.MessageBox.alert("旋转角度1_输入格式有误！[0,无,输入角度后选择偏移生成方式]");
			return;
		} 
	}
	
	if (typeof angle2 !== 'undefined') {
		if (angle2 == "0[折弯获得]" || angle2 == "0[机加获得]") {
			dorado.MessageBox.alert("旋转角度2_输入格式有误！[0,无,输入角度后选择偏移生成方式]");
			return;
		}
		if (angle2 != "无" && angle2 != "0" && !pattern.exec(angle2)) {
			dorado.MessageBox.alert("旋转角度2_输入格式有误！[0,无,输入角度后选择偏移生成方式]");
			return;
		} 
	}
	
	if (typeof angle3 !== 'undefined') {
		if (angle3 == "0[折弯获得]" || angle3 == "0[机加获得]") {
			dorado.MessageBox.alert("旋转角度3_输入格式有误！[0,无,输入角度后选择偏移生成方式]");
			return;
		}
		if (angle3 != "无" && angle3 != "0" && !pattern.exec(angle3)) {
			dorado.MessageBox.alert("旋转角度3_输入格式有误！[0,无,输入角度后选择偏移生成方式]");
			return;
		} 
	}
	
	ajaxActionCode.set("parameter",view.id("autoformAdd").get("entity").toJSON()).execute();

};

// @Bind #ajaxActionCode.onSuccess
!function(self, arg, updateactionSave) {
	var returnValue = self.get("returnValue");
	// 编码成功
	if (returnValue.flag == "S_OK") {
		var codeValue = returnValue.coderesult;
		view.id("autoformAdd").get("entity").set("shankCode", codeValue);
		view.id("autoFormBasicAttr").get("entity").set("shankCode", codeValue);
		updateactionSave.execute();
	} else {
		dorado.MessageBox.confirm("因参数不完整，未能成功编码，是否继续保存？", function() {
			view.id("autoformAdd").get("entity").set("shankCode", "");
			view.id("autoFormBasicAttr").get("entity").set("shankCode", "");
			updateactionSave.execute();
		});
		return;
	}
};

// @Bind #updateactionSave.onSuccess
!function(self, arg, ajaxActionJudgeStringIsSatisfied) {
	var flag = view.id("updateactionSave").get("userData");
	if (view.isEmpty(flag)) {
		ajaxActionJudgeStringIsSatisfied.set("parameter",
				view.id("autoformAdd").get("entity").toJSON()).execute();
	}
	
};

// @Bind #ajaxActionJudgeStringIsSatisfied.onSuccess
!function(self, updateactionSave) {
	var returnValue = self.get("returnValue");
	if (returnValue.flag == "S_OK") {
		dorado.widget.NotifyTipManager.notify("添加完成......!");
		view.id("dialogEditShank").hide();
	} else {
		dorado.MessageBox.alert(returnValue.flag);
	}
};

// @Bind #datagridShank.onContextMenu
!function(self, arg, menuContextDataGrid) {
	menuContextDataGrid.show({
		position : {
			left : arg.event.pageX,
			top : arg.event.pageY
		}
	});
};

// 表格右键更多信息
// @Bind #menuItemDetail.onClick
!function(self, ar, dialogInfo, datagridShank) {
	// imageModelDetail.set("image","images\\ModelDetail\\"+literatureId+".JPG");
	var dialogName = datagridShank.getCurrentItem().get("shankDrawingno");
	dialogInfo.set("caption", "详细信息->电极握杆图号:" + dialogName);
	dialogInfo.show();
};

// 表格右键更多信息对话框关闭按钮
// @Bind #buttonCancel2.onClick
!function(self, ar, dialogInfo, datagridShank, dsHolder) {
	// imageModelDetail.set("image","images\\ModelDetail\\"+literatureId+".JPG");
	dialogInfo.hide();
	dsHolder.flush();
};

// @Bind #buttonModify.onClick
!function(self, arg, dialogEditShank, uploadFileTipLabel) {
	view.id("updateactionSave").set("userData",null);
	dialogEditShank.show();
	dorado.MessageBox.alert("注意：修改模式下上传文件将覆盖原始相关文件!");
	dialogEditShank.set("tags", "Modify");
	uploadFileTipLabel.set("visible", true);
	
	view.id("buttonSave1").set("disabled",false);
	view.id("buttonUpload2DDrawing").set("disabled",false);
	view.id("buttonUploadDrawing").set("disabled",false);
	
};

// @Bind #buttonDelete.onClick
!function(self, arg, dialogEdit, dsHolder, updateactionSave,
		ajaxActionDeleteRelatedFiles) {
	var entity = dsHolder.get("data:#");
	if (entity) {

		dorado.MessageBox.confirm("是否要要删除记录对应的文件？", function() {
			ajaxActionDeleteRelatedFiles.set("parameter", entity.get("id"))
					.execute();
		});
		dorado.MessageBox.confirm("确认要删除记录吗？", function() {
			entity.remove();
			// 设置标记，如果该标记存在，那么就用执行ajaxjudge条件是否满足
			view.id("updateactionSave").set("userData","flag");
			updateactionSave.execute();
		});

	}
};

// @Bind #datagridShank.onCreate
!function(self, arg, dialog2DDrawing, image) {
	var OperationCellRenderer1 = $extend(
			dorado.widget.grid.SubControlCellRenderer,
			{
				createSubControl : function(arg) {
					if (arg.data.rowType)
						return null;
					// 返回按钮对象并为按钮对象绑定onClick事件
					return new dorado.widget.Button(
							{
								onClick : function(dialog2DDrawing, image) {
									dorado.widget.NotifyTipManager
											.notify("正在为您打开二维图......!");
									var msg = "${servletContext.getAttribute('configprop').get('TURRETSHANK2D_PATH')}";
									image.set("image", msg
											+ self.getCurrentItem().get(
													"shankDrawingno") + ".jpg");
									dialog2DDrawing.show();
								}
							});
				},
				refreshSubControl : function(button, arg) {
					button.set({
						caption : "二维图",
						icon : "url(>skin>common/icons.gif) -120px -60px",
						style : "margin:0 2px;color:blue",
						disabled : false
					});

				}
			});
	self.set("#operation.renderer", new OperationCellRenderer1());
};

// @Bind #menuItemOpen2DDrawing.onClick
!function(dialog2DDrawing, image) {
	dorado.widget.NotifyTipManager.notify("正在为您打开二维图......!");
	var msg = "${servletContext.getAttribute('configprop').get('TURRETSHANK2D_PATH')}";
	image.set("image", msg
			+ view.id("datagridShank").getCurrentItem().get("shankDrawingno")
			+ ".jpg");
	dialog2DDrawing.show();
};

// @Bind #menuItemDownLoad3DFile.onClick
!function(self, downloadDrawing, datagridShank) {
	dorado.MessageBox.confirm("确认下载三维数模？", function() {
		var shankDrawingno = datagridShank.getCurrentItem().get(
				"shankDrawingno");
		var shankDrawingnoMap = new dorado.util.Map();
		shankDrawingnoMap.put("shankDrawingno", shankDrawingno);
		view.id("downloadDrawing").set("parameter", shankDrawingnoMap)
				.execute();
	});
};

// @Bind #buttonUploadDrawing.onClick
!function() {
	if (view.id("dialogEditShank").get("tags") == "Modify") {
		dorado.widget.NotifyTipManager.notify("确认修改重新上传数模文件？原始数模文件将被覆盖！");
	}
	var json = view.id("autoformAdd").get("entity").toJSON();
	json["tag"] = "uploadDrawing";
	view.id("uploadDrawing").set("parameter", json).execute();
};

// 文件上传完成之后
// 未解决问题：文件上传失败之后，临时文件为处理
// @Bind #uploadDrawing.onFileUploaded
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

// @Bind #ajaxActionDeleteRelatedFiles.onSuccess
!function(self, arg) {
	dorado.widget.NotifyTipManager.notify(self.get("returnValue"));
};

// @Bind #buttonUpload2DDrawing.onClick
!function() {
	if (view.id("dialogEditShank").get("tags") == "Modify") {
		dorado.widget.NotifyTipManager.notify("确认修改重新上传二维图纸文件？原始二维图纸文件将被覆盖！");
	}
	var json = view.id("autoformAdd").get("entity").toJSON();
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

// @Bind #datagridShank.onRenderHeaderCell
!function(arg) {
	arg.dom.style.backgroundcolor = "skyblue";
	// arg.dom.style.color = "red";
	arg.dom.style.fontSize = "30";
	arg.dom.style.height = "50";
	arg.processDefault = true;
};

// @Bind #datagridShank.#shankDrawingno.onRenderCell
!function(arg) {
	// arg.dom.style.background = (arg.data.get("armassemblyCode") > 3000) ?
	// "#fcc5c5" : "";
	// view.downloadFile();
	var shankDrawingno = arg.data.get("shankDrawingno");
	arg.dom.innerHTML = "<a href='javascript:view.downloadFile()'>"
			+ shankDrawingno + "</a>";
	// 另外一种实现方式
	// arg.dom.innerHTML = "<div style='cursor:pointer;color:blue'><u>"
	// + armAssemblyno + "</u></div>";
	// arg.processDefault = true;
};

// @Bind #saveAllAttrInfo.onClick
!function(self, arg) {
	view.id("dialogInfo").show();
};

// @Bind #buttonSaveAll.onClick
!function(self, arg) {
	// 先去编码
	var entity = view.id("autoformAdd").get("entity");
	var angle1 = entity.get("shankAngel1");
	var angle2 = entity.get("shankAngel2");
	var angle3 = entity.get("shankAngel3");

	var pattern = /^[0-9]+([.]{1}[0-9]+){0,1}(\[[\u2E80-\u9FFF]+\]){1}$/;

	if (typeof angle1 !== 'undefined') {
		if (angle1 == "0[折弯获得]" || angle1 == "0[机加获得]") {
			dorado.MessageBox.alert("旋转角度1_输入格式有误！[0,无,输入角度后选择偏移生成方式]");
			return;
		}
		if (angle1 != "无" && angle1 != "0" && !pattern.exec(angle1)) {
			dorado.MessageBox.alert("旋转角度1_输入格式有误！[0,无,输入角度后选择偏移生成方式]");
			return;
		} 
	}
	
	if (typeof angle2 !== 'undefined') {
		if (angle2 == "0[折弯获得]" || angle2 == "0[机加获得]") {
			dorado.MessageBox.alert("旋转角度2_输入格式有误！[0,无,输入角度后选择偏移生成方式]");
			return;
		}
		if (angle2 != "无" && angle2 != "0" && !pattern.exec(angle2)) {
			dorado.MessageBox.alert("旋转角度2_输入格式有误！[0,无,输入角度后选择偏移生成方式]");
			return;
		} 
	}
	
	if (typeof angle3 !== 'undefined') {
		if (angle3 == "0[折弯获得]" || angle3 == "0[机加获得]") {
			dorado.MessageBox.alert("旋转角度3_输入格式有误！[0,无,输入角度后选择偏移生成方式]");
			return;
		}
		if (angle3 != "无" && angle3 != "0" && !pattern.exec(angle3)) {
			dorado.MessageBox.alert("旋转角度3_输入格式有误！[0,无,输入角度后选择偏移生成方式]");
			return;
		} 
	}
	
	ajaxActionCode.set("parameter",view.id("autoformAdd").get("entity").toJSON()).execute();

};

// @Bind #buttonEditInToolbar.onClick
!function(self, arg) {
	if (view.id("autoFormBasicAttr").get("readOnly") == true) {
		view.id("autoFormBasicAttr").set("readOnly", false);
		view.id("buttonSaveAll").set("disabled", false);
	} else {
		view.id("autoFormBasicAttr").set("readOnly", true);
		view.id("buttonSaveAll").set("disabled", true);
	}
};

// 工具栏simplebutton第一条记录
// @Bind #simpleButtonFirstRecord.onClick
!function(self, arg) {
	// alert(1);
	var entityList = view.id("dsHolder").getData();
	var entityFirst = entityList.getFirst();
	// alert(entityFirst.get("shankDrawingno"));
	view.id("datagridShank").setCurrentEntity(entityFirst);
	view.id("autoFormBasicAttr").set("entity", entityFirst);
	// console.log(1);
	view.id("autoFormBasicAttr").refresh();

};

/*
 * //工具栏simplebutton第一条记录 !function(self,arg) { //alert(1); var entityList =
 * view.id("dsHolder").getData(); var entityLast = entityList.getLast();
 * //alert(entityFirst.get("shankDrawingno"));
 * view.id("datagridShank").setCurrentEntity(entityLast);
 * view.id("datagridShank").highlightItem(entityLast); //
 * view.id("autoFormBasicAttr").set("entity",entityLast.toJSON());
 * view.id("autoFormBasicAttr").get("entity").set("shankDrawingno","123");
 * console.log(2);
 *  };
 */

// var shankDrawingno =
// view.id("datagridShank").getCurrentItem().get("shankDrawingno");

// @Bind #datagridShank.#shankCode.onRenderCell
!function(arg) {
	// arg.dom.style.background = (arg.data.get("armassemblyCode") > 3000) ?
	// "#fcc5c5" : "";
	arg.dom.style.background = "#FFD39B";
	arg.dom.style.color = "red";
	var shankCode = arg.data.get("shankCode");
	// arg.dom.innerHTML = "<a
	// href='com.nimak.viewsets.TurretInfoManage.d'>"+armassemblyCode+"</a>";
	arg.processDefault = true;
};

// @Bind #frame.onLoad
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

//只有当图号不为空时才能进行上传或者保存等操作
//@Bind #autoformAdd.#shankDrawingno.onBlur
!function(buttonSave1,self,arg,buttonUploadDrawing,buttonUpload2DDrawing) {
	
	var eleValue = self.get("value");
	if(!view.isEmpty(eleValue)) {
		buttonSave1.set("disabled",false);
		buttonUpload2DDrawing.set("disabled",false);
		buttonUploadDrawing.set("disabled",false);
	}else {
		buttonSave1.set("disabled",true);
		buttonUpload2DDrawing.set("disabled",true);
		buttonUploadDrawing.set("disabled",true);
	}
};


