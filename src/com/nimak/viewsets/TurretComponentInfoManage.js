var flag = 0;
/** @View */
function downloadFile() {
	dorado.MessageBox.confirm("即将开始下载钳臂部件三维数模！确认继续？", function() {
		var armAssemblyno = view.id("datagridTurretComponent").getCurrentItem().get("armAssemblyno");
		var armAssemblynoMap = new dorado.util.Map();
		armAssemblynoMap.put("armAssemblyno", armAssemblyno);
		view.id("downloadDrawing").set("parameter", armAssemblynoMap).execute();
	});
}

//@Bind #view.onCreate
!function(self,arg) {
	dorado.useObjectShim = true;
	view.$onMathTriggerExecute = function(self, arg) {
		var n = arg.editor.get("value");
		//n = eval(n + self.get("userData"));
		if (n == null || n == "") {
			return;
		}
		// 没有点击后面的trigger
		if (n.indexOf("折弯") == -1 && n.indexOf("机加") == -1) {
			n = n +  self.get("userData");
		}
		var flag = self.get("userData");
		// 点击时，字符串中已有【】
		if (n.indexOf("[") != -1) {
			n = n.substring(0,n.indexOf("[")) + flag;
		}
		
		arg.editor.set("value", n);
		//view.id("autoformTurretComOrPartInfo2").get("entity").set("shankAngel1",n);
	};	
};


//@Bind #view.onReady
!function(self,arg) {
	view.id("ajaxActionLoadAllArmDrawingnos").execute();
	view.id("ajaxActionLoadAllShankDrawingnos").execute();
};



/** @View */
function showCompOrPartInfo(label) {
	alert(label);
} 


// @Bind #dataSet1.onCreate
!function(self, arg) {
	self.insert();
};

// @Bind #dsTurretComponentComponent.onCreate
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
!function(self, autoformCondition, dsTurretComponent) {
	// 获取autoformCondition绑定的实体对象
	var entityJson = autoformCondition.get("entity").toJSON();
	dsTurretComponent.set("parameter", entityJson).flushAsync();
	
	
	// 自动填充下拉框==armAssemblyno===============================================================
	var newItemArmAssemblyno = autoformCondition.get("entity").get("armAssemblyno");
	var itemsArmAssemblyno = new Array();
	var objectArmAssemblyno= view.id("listDropDownArmAssemblyno").get("items");
	if(objectArmAssemblyno != null){
		itemsArmAssemblyno = Object.values(objectArmAssemblyno);
	}
	// 数组首位添加元素
	if (newItemArmAssemblyno != null && newItemArmAssemblyno != "") {
		// 循环遍历元素，如果新添加的元素已经在下拉表中，将原始下拉表中该元素删除。
		for(var i in itemsArmAssemblyno) {
			if(newItemArmAssemblyno == itemsArmAssemblyno[i]) {
				itemsArmAssemblyno.remove(itemsArmAssemblyno[i]);
			}
		}
		itemsArmAssemblyno.unshift(newItemArmAssemblyno);
	}
	// 下拉框设置为6各元素
	if (itemsArmAssemblyno.length > 6) {
		itemsArmAssemblyno.pop();
	}	
	view.id("listDropDownArmAssemblyno").set("items",itemsArmAssemblyno);
	view.id("armAssemblynoForm").set("trigger","listDropDownArmAssemblyno");
	//==================================================================================
	
	// 自动填充下拉框==width2===============================================================
	var newItem = autoformCondition.get("entity").get("armassemblyWidth2");
	var items = new Array();
	var object= view.id("listDropDownArmAssemblyWidth2").get("items");
	if(object != null){
		items = Object.values(object);
	}
	// 数组首位添加元素
	if (newItem != null && newItem != "") {
		// 循环遍历元素，如果新添加的元素已经在下拉表中，将原始下拉表中该元素删除。
		for(var i in items) {
			if(newItem == items[i]) {
				items.remove(items[i]);
			}
		}
		items.unshift(newItem);
	}
	// 下拉框设置为6各元素
	if (items.length > 6) {
		items.pop();
	}	
	view.id("listDropDownArmAssemblyWidth2").set("items",items);
	view.id("armassemblyWidth2Form").set("trigger","listDropDownArmAssemblyWidth2");
	//==================================================================================
	
	
	// 自动填充下拉框==width===============================================================
	var newItemWidth = autoformCondition.get("entity").get("armassemblyWidth");
	var itemsWidth = new Array();
	var objectWidth= view.id("listDropDownArmAssemblyWidth").get("items");
	if(objectWidth != null){
		itemsWidth = Object.values(objectWidth);
	}
	// 数组首位添加元素
	if (newItemWidth != null && newItemWidth != "") {
		// 循环遍历元素，如果新添加的元素已经在下拉表中，将原始下拉表中该元素删除。
		for(var i in itemsWidth) {
			if(newItemWidth == itemsWidth[i]) {
				itemsWidth.remove(itemsWidth[i]);
			}
		}
		itemsWidth.unshift(newItemWidth);
	}
	// 下拉框设置为6各元素
	if (itemsWidth.length > 6) {
		itemsWidth.pop();
	}	
	view.id("listDropDownArmAssemblyWidth").set("items",itemsWidth);
	view.id("armassemblyWidthForm").set("trigger","listDropDownArmAssemblyWidth");
	//==================================================================================
	
	// 自动填充下拉框==length===============================================================
	var newItemLength = autoformCondition.get("entity").get("armassemblyLength");
	var itemsLength = new Array();
	var objectLength= view.id("listDropDownArmAssemblyLength").get("items");
	if(objectLength != null){
		itemsLength = Object.values(objectLength);
	}
	// 数组首位添加元素
	if (newItemLength != null && newItemLength != "") {
		// 循环遍历元素，如果新添加的元素已经在下拉表中，将原始下拉表中该元素删除。
		for(var i in itemsLength) {
			if(newItemLength == itemsLength[i]) {
				itemsLength.remove(itemsLength[i]);
			}
		}
		itemsLength.unshift(newItemLength);
	}
	// 下拉框设置为6各元素
	if (itemsLength.length > 6) {
		itemsLength.pop();
	}	
	view.id("listDropDownArmAssemblyLength").set("items",itemsLength);
	view.id("armassemblyLengthForm").set("trigger","listDropDownArmAssemblyLength");
	//==================================================================================
	
	// 自动填充下拉框==force===============================================================
	var newItemForce = autoformCondition.get("entity").get("force");
	var itemsForce = new Array();
	var objectForce= view.id("listDropDownArmAssemblyForce").get("items");
	if(objectForce != null){
		itemsForce = Object.values(objectForce);
	}
	// 数组首位添加元素
	if (newItemForce != null && newItemForce != "") {
		// 循环遍历元素，如果新添加的元素已经在下拉表中，将原始下拉表中该元素删除。
		for(var i in itemsForce) {
			if(newItemForce == itemsForce[i]) {
				itemsForce.remove(itemsForce[i]);
			}
		}
		itemsForce.unshift(newItemForce);
	}
	// 下拉框设置为6各元素
	if (itemsForce.Force > 6) {
		itemsForce.pop();
	}	
	view.id("listDropDownArmAssemblyForce").set("items",itemsForce);
	view.id("forceForm").set("trigger","listDropDownArmAssemblyForce");
	//==================================================================================
	
	
	/*// 自动填充下拉框==capAngel===============================================================
	var newItemCapAngel = autoformCondition.get("entity").get("capAngel");
	var itemsCapAngel = new Array();
	var objectCapAngel= view.id("listDropDownArmAssemblyCapAngel").get("items");
	if(objectCapAngel != null){
		itemsCapAngel = Object.values(objectCapAngel);
	}
	// 数组首位添加元素
	if (newItemCapAngel != null && newItemCapAngel != "") {
		// 循环遍历元素，如果新添加的元素已经在下拉表中，将原始下拉表中该元素删除。
		for(var i in itemsCapAngel) {
			if(newItemCapAngel == itemsCapAngel[i]) {
				itemsCapAngel.remove(itemsCapAngel[i]);
			}
		}
		itemsCapAngel.unshift(newItemCapAngel);
	}
	// 下拉框设置为6各元素
	if (itemsCapAngel.CapAngel > 6) {
		itemsCapAngel.pop();
	}	
	view.id("listDropDownArmAssemblyCapAngel").set("items",itemsCapAngel);
	view.id("capAngelForm").set("trigger","listDropDownArmAssemblyCapAngel");*/
	//==================================================================================
	
	
	// 自动填充下拉框==Code===============================================================
	var newItemCode = autoformCondition.get("entity").get("armassemblyCode");
	var itemsCode = new Array();
	var objectCode= view.id("listDropDownArmAssemblyCode").get("items");
	if(objectCode != null){
		itemsCode = Object.values(objectCode);
	}
	// 数组首位添加元素
	if (newItemCode != null && newItemCode != "") {
		// 循环遍历元素，如果新添加的元素已经在下拉表中，将原始下拉表中该元素删除。
		for(var i in itemsCode) {
			if(newItemCode == itemsCode[i]) {
				itemsCode.remove(itemsCode[i]);
			}
		}
		itemsCode.unshift(newItemCode);
	}
	// 下拉框设置为6各元素
	if (itemsCode.Code > 6) {
		itemsCode.pop();
	}	
	view.id("listDropDownArmAssemblyCode").set("items",itemsCode);
	view.id("armassemblyCodeForm").set("trigger","listDropDownArmAssemblyCode");
	//==================================================================================
};

/*
 * if(!self.get("data").getLast()) {
 * //dorado.MessageBox.alert("没有找到满足条件的设计，请重新限定条件查询...");
 * dorado.widget.NotifyTipManager.notify("没有找到满足条件的设计，请重新限定条件查询..."); }
 */

// @Bind #buttonAdd.onClick
// @Bind #buttonAddInToolbar.onClick
!function(self, arg, dialogEditTurretComponent, dsTurretComponent, autoformAdd) {
	// id设置为自动加1
	/*
	 * var aa = new Array(); aa = dsTurretComponent.get("data"); var temp = new Array();
	 * var i=1,num=0; aa.each(function(entity){ temp.push(entity.get("id"));
	 * i++; }); num = Math.max.apply(null,temp)+1;
	 */
	// console.log(num);
	dsTurretComponent.insert();
	view.id("updateactionSave").set("userData",null);
	// autoformAdd.get("entity").set("id",num);
	dialogEditTurretComponent.show();
	dialogEditTurretComponent.set("tags", "Add");
	view.id("uploadFileTipLabel").set("visible",false);
	
	view.id("buttonSave1").set("disabled",true);
	view.id("buttonUpload2DDrawing").set("disabled",true);
	view.id("buttonUploadDrawing").set("disabled",true);
};

// @Bind #buttonCancel1.onClick
!function(self, dsTurretComponent, dialogEditTurretComponent) {
	
	// 如果是修改：
	if(dialogEditTurretComponent.get("tags") == "Modify") {
		dsTurretComponent.get("data:#").cancel();
		dialogEditTurretComponent.hide();
	}
	// 如果是添加：
	if (dialogEditTurretComponent.get("tags") == "Add") {
		var entity = dsTurretComponent.get("data:#");
		entity.remove();
		view.id("updateactionSave").execute();
		dialogEditTurretComponent.hide();
	}	
};

// 添加或者修改编辑对话框中保存按钮
// @Bind #buttonSave1.onClick
!function(self, autoformAdd, updateactionSave,ajaxActionJudgeStringIsSatisfied) {
	updateactionSave.execute();
	ajaxActionJudgeStringIsSatisfied.set("parameter",
			autoformAdd.get("entity").toJSON()).execute();
};

// @Bind #ajaxActionJudgeStringIsSatisfied.onSuccess
!function(self, updateactionSave) {
	var returnValue = self.get("returnValue");
	if (returnValue.flag == "S_OK") {
		var codeValue = returnValue.coderesult;
		if (codeValue == null) {
			dorado.MessageBox.confirm("编码失败,是否继续保存?", function() {
				view.id("autoformAdd").get("entity").set("armassemblyCode",codeValue);
				updateactionSave.execute();
				view.id("dialogEditTurretComponent").hide();
				return;
			});
		}else {
			view.id("autoformAdd").get("entity").set("armassemblyCode",codeValue);
			updateactionSave.execute();
			view.id("dialogEditTurretComponent").hide();
			return;
		}
	} else {
		dorado.MessageBox.confirm(returnValue.flag+"是否继续保存?", function() {
			var codeValue = returnValue.coderesult;
			if (codeValue == null) {
				dorado.MessageBox.confirm("编码失败,是否继续保存?", function() {
					view.id("autoformAdd").get("entity").set("armassemblyCode",codeValue);
					updateactionSave.execute();
					view.id("dialogEditTurretComponent").hide();
					return;
				});
			}else {
				view.id("autoformAdd").get("entity").set("armassemblyCode",codeValue);
				updateactionSave.execute();
				view.id("dialogEditTurretComponent").hide();
				return;
			}
		});		
	}
	
};

// @Bind #updateactionSave.onSuccess
!function(self, dialogEditTurretComponent) {
	// 如果成功
	//dialogEditTurretComponent.hide();
};

// @Bind #datagridTurretComponent.onContextMenu
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
!function(self, ar, dialogInfo, datagridTurretComponent) {
	// imageModelDetail.set("image","images\\ModelDetail\\"+literatureId+".JPG");
	var dialogName = datagridTurretComponent.getCurrentItem().get("armAssemblyno");
	dialogInfo.set("caption", dialogName);
	dialogInfo.show();
};

// 表格右键更多信息对话框关闭按钮
// @Bind #buttonCancel2.onClick
!function(self, ar, dialogInfo, datagridTurretComponent, dsTurretComponent) {
	// imageModelDetail.set("image","images\\ModelDetail\\"+literatureId+".JPG");
	dialogInfo.hide();
	dsTurretComponent.flush();
};

// @Bind #buttonModify.onClick
!function(self, arg, dialogEditTurretComponent,uploadFileTipLabel) {
	dialogEditTurretComponent.show();
	view.id("updateactionSave").set("userData",null);
	dorado.MessageBox.alert("注意：修改模式下上传文件将覆盖原始相关文件!");
	dialogEditTurretComponent.set("tags", "Modify");
	uploadFileTipLabel.set("visible",true);
	
	view.id("buttonSave1").set("disabled",false);
	view.id("buttonUpload2DDrawing").set("disabled",false);
	view.id("buttonUploadDrawing").set("disabled",false);
};

// @Bind #buttonDelete.onClick
!function(self, arg, dialogEdit, dsTurretComponent, updateactionSave,
		ajaxActionDeleteRelatedFiles) {
	var entity = dsTurretComponent.get("data:#");
	if (entity) {
		
		dorado.MessageBox.confirm("是否要要删除记录对应的文件？", function() {
			ajaxActionDeleteRelatedFiles.set("parameter", entity.get("id"))
							.execute();
		});
		dorado.MessageBox.confirm("确认要删除记录吗？", function() {
			entity.remove();
			updateactionSave.execute();
		});
		
	}
};

// @Bind #datagridTurretComponent.onCreate
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
									var msg = "${servletContext.getAttribute('configprop').get('TURRETCOMPONENT2D_PATH')}";
									image.set("image", msg
											+ self.getCurrentItem().get(
													"armAssemblyno") + ".jpg");
									dialog2DDrawing.show();
								}
							});
				},
				refreshSubControl : function(button, arg) {
					button.set({
						caption : "二维图",
						icon : "url(>skin>common/icons.gif) -120px -60px",
						style:"margin:0 2px;color:blue",
						disabled : false
					});
					
				}
			});
	self.set("#operation.renderer", new OperationCellRenderer1());
	
	
	var OperationCellRenderer1 = $extend(
			dorado.widget.grid.SubControlCellRenderer,
			{
				createSubControl : function(arg) {
					if (arg.data.rowType)
						return null;
					// 返回按钮对象并为按钮对象绑定onClick事件
					return new dorado.widget.Button(
							{
								onClick : function(dialogPartInfo,treePartInfo,datagridTurretComponent) {
									// 部件组件零件信息树，自动添加节点
									treePartInfo.clearNodes();
									var rootNode = treePartInfo.get("root");
									rootNode.addNode(new dorado.widget.tree.BaseNode({
										label:"钳臂组件:"+datagridTurretComponent.getCurrentItem().get("armComponentno"),
									}));
									rootNode.addNode(new dorado.widget.tree.BaseNode({
										label:"电极握杆组件:"+datagridTurretComponent.getCurrentItem().get("shankComponentno"),
									}));
									rootNode.addNode(new dorado.widget.tree.BaseNode({
										label:"钳臂零件:"+datagridTurretComponent.getCurrentItem().get("armDrawingno"),
									}));
									rootNode.addNode(new dorado.widget.tree.BaseNode({
										label:"电极握杆零件:"+datagridTurretComponent.getCurrentItem().get("shankDrawingno"),
									}));
									// 表单对应的dataset更新
									view.id("dsTurretCompOrPart").clear();
									view.id("dsTurretCompOrPart").set("parameter", view.id("datagridTurretComponent").getCurrentItem().get("armComponentno")).flushAsync();
									
									view.id("tabControlInfo1").set("visible",true);
									
									view.id("tabControlInfo2").set("visible",false);
									view.id("tabControlInfo3").set("visible",false);
									view.id("tabControlInfo4").set("visible",false);
									
									dialogPartInfo.show();
								}
							});
				},
				refreshSubControl : function(button, arg) {
					button.set({
						caption : "组件零件",
						icon : "url(>skin>common/icons.gif) -120px -60px",
						style:"margin:0 2px;color:blue",
						disabled : false
					});
					
				}
			});
	self.set("#partInfo.renderer", new OperationCellRenderer1());
	
};




// @Bind #menuItemOpenPart.onClick
!function(dialogPartInfo,treePartInfo,datagridTurretComponent) {
	// 部件组件零件信息树，自动添加节点
	treePartInfo.clearNodes();
	var rootNode = treePartInfo.get("root");
	rootNode.addNode(new dorado.widget.tree.BaseNode({
		label:"钳臂组件:"+datagridTurretComponent.getCurrentItem().get("armComponentno"),
		icon : " url(>skin>common/icons.gif) -60px -40px",
	}));
	rootNode.addNode(new dorado.widget.tree.BaseNode({
		label:"电极握杆组件:"+datagridTurretComponent.getCurrentItem().get("shankComponentno"),
		icon : " url(>skin>common/icons.gif) -60px -40px",
	}));
	rootNode.addNode(new dorado.widget.tree.BaseNode({
		label:"钳臂零件:"+datagridTurretComponent.getCurrentItem().get("armDrawingno"),
		icon : " url(>skin>common/icons.gif) -60px -40px",
	}));
	rootNode.addNode(new dorado.widget.tree.BaseNode({
		label:"电极握杆零件:"+datagridTurretComponent.getCurrentItem().get("shankDrawingno"),
		icon : " url(>skin>common/icons.gif) -60px -40px",
	}));
	// 表单对应的dataset更新
	view.id("dsTurretCompOrPart").clear();
	view.id("dsTurretCompOrPart").set("parameter", view.id("datagridTurretComponent").getCurrentItem().get("armComponentno")).flushAsync();
	
	view.id("tabControlInfo1").set("visible",true);
	
	view.id("tabControlInfo2").set("visible",false);
	view.id("tabControlInfo3").set("visible",false);
	view.id("tabControlInfo4").set("visible",false);
	
	dialogPartInfo.show();
};



// @Bind #menuItemOpen2DDrawing.onClick
!function(dialog2DDrawing, image) {
	dorado.widget.NotifyTipManager.notify("正在为您打开二维图......!");
	var msg = "${servletContext.getAttribute('configprop').get('TURRETCOMPONENT2D_PATH')}";
	image.set("image", msg + view.id("datagridTurretComponent").getCurrentItem().get("armAssemblyno")
			+ ".jpg");
	dialog2DDrawing.show();
};



// 右键打包下载部件相关数模
//@Bind #menuItemDownloadZip.onClick
!function(datagridTurretComponent,downloadDrawingZip, image) {
	dorado.MessageBox.confirm("确认打包下载三维数模(包括部件及其构成组件数模)？", function() {
		var armAssemblyno = datagridTurretComponent.getCurrentItem().get("armAssemblyno");
		var shankComponentno = datagridTurretComponent.getCurrentItem().get("shankComponentno");
		var armComponentno = datagridTurretComponent.getCurrentItem().get("armComponentno");
		
		var paraMap = new dorado.util.Map();
		paraMap.put("armAssemblyno", armAssemblyno);
		paraMap.put("shankComponentno", shankComponentno);
		paraMap.put("armComponentno", armComponentno);
		view.id("downloadDrawingZip").set("parameter", paraMap).execute();
	});
};



// @Bind #menuItemDownLoad3DFile.onClick
!function(self, downloadDrawing, datagridTurretComponent) {
	dorado.MessageBox.confirm("确认下载三维数模？", function() {
		var armAssemblyno = datagridTurretComponent.getCurrentItem().get("armAssemblyno");
		var armAssemblynoMap = new dorado.util.Map();
		armAssemblynoMap.put("armAssemblyno", armAssemblyno);
		view.id("downloadDrawing").set("parameter", armAssemblynoMap).execute();
	});
};

// @Bind #buttonUploadDrawing.onClick
!function() {
	if (view.id("dialogEditTurretComponent").get("tags") == "Modify") {
		dorado.widget.NotifyTipManager.notify("确认修改重新上传数模文件？原始数模文件将被覆盖！");
	}
	var json = view.id("autoformAdd").get("entity").toJSON();
	json["tag"] = "uploadDrawing";
	view.id("uploadDrawing").set("parameter",json);
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
!function(self,arg){
	dorado.widget.NotifyTipManager.notify(self.get("returnValue"));
};

//@Bind #buttonUpload2DDrawing.onClick
!function() {
	if (view.id("dialogEditTurretComponent").get("tags") == "Modify") {
		dorado.widget.NotifyTipManager.notify("确认修改重新上传二维图纸文件？原始二维图纸文件将被覆盖！");
	}
	var json = view.id("autoformAdd").get("entity").toJSON();
	json["tag"] = "upload2DDrawing";
	view.id("upload2DDrawing").set("parameter",json);
};

//文件上传完成之后
//未解决问题：文件上传失败之后，临时文件为处理
//@Bind #upload2DDrawing.onFileUploaded
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


// @Bind #datagridTurretComponent.onRenderHeaderCell
!function(arg) {
	arg.dom.style.backgroundcolor = "skyblue";
	//arg.dom.style.color = "red";
	arg.dom.style.fontSize = "30";
	arg.dom.style.height = "50";
	arg.processDefault = true;
};



// @Bind #datagridTurretComponent.#armassemblyCode.onRenderCell
!function(arg) {
    //arg.dom.style.background = (arg.data.get("armassemblyCode") > 3000) ? "#fcc5c5" : "";
	arg.dom.style.background = "#FFD39B";
	arg.dom.style.color = "red";
	var armassemblyCode = arg.data.get("armassemblyCode");
	//arg.dom.innerHTML = "<a href='com.nimak.viewsets.TurretInfoManage.d'>"+armassemblyCode+"</a>";
    arg.processDefault = true;
};

//@Bind #datagridTurretComponent.#armAssemblyno.onRenderCell
!function(arg) {
    //arg.dom.style.background = (arg.data.get("armassemblyCode") > 3000) ? "#fcc5c5" : "";
	//view.downloadFile();
	var armAssemblyno = arg.data.get("armAssemblyno");
	arg.dom.innerHTML = "<a href='javascript:view.downloadFile()'>"+armAssemblyno+"</a>";
	// 另外一种实现方式
	//arg.dom.innerHTML = "<div style='cursor:pointer;color:blue'><u>"
		//+ armAssemblyno + "</u></div>";	
	//arg.processDefault = true;
};



//@Bind #datagridTurretComponent.#gunType.onRenderCell
!function(arg) {
	var gunType = arg.data.get("gunType");
	if (typeof gunType !== 'undefined') {
		if (gunType.indexOf("C") == -1) {
			arg.dom.style.color = "#7D26CD";
		}else {
			arg.dom.style.color = "red";
		}
	}	
	arg.processDefault = true;
};



// @Bind #buttonInDlgPartInfo.onClick
!function() {
	view.id("dialogPartInfo").hide();
};

// @Bind #treePartInfo.onDataRowClick
!function(self,dsTurretCompOrPart,dsHolder) {
	var currentNode = self.get("currentNode");
	var nodeLabel = currentNode.get("label");
	if(nodeLabel.indexOf("钳臂组件") != -1) {
		// 表单对应的dataset更新
		dsTurretCompOrPart.clear();
		dsTurretCompOrPart.set("parameter", view.id("datagridTurretComponent").getCurrentItem().get("armComponentno")).flushAsync();
		
		// 表单显示
		view.id("tabControlInfo1").set("visible",true);
		
		view.id("tabControlInfo2").set("visible",false);
		view.id("tabControlInfo3").set("visible",false);
		view.id("tabControlInfo4").set("visible",false);
	}else if(nodeLabel.indexOf("电极握杆组件") != -1) {
		// 表单对应的dataset更新
		dsHolder.clear();
		dsHolder.set("parameter", view.id("datagridTurretComponent").getCurrentItem().get("shankDrawingno")).flushAsync();
		
		// 表单显示		
		view.id("tabControlInfo2").set("visible",true);
		
		view.id("tabControlInfo1").set("visible",false);
		view.id("tabControlInfo3").set("visible",false);
		view.id("tabControlInfo4").set("visible",false);
	}else if(nodeLabel.indexOf("钳臂零件") != -1) {
		// 表单对应的dataset更新
		dsTurretCompOrPart.clear();
		dsTurretCompOrPart.set("parameter", view.id("datagridTurretComponent").getCurrentItem().get("armComponentno")).flushAsync();
		
		// 表单显示
		view.id("tabControlInfo3").set("visible",true);
		
		view.id("tabControlInfo2").set("visible",false);
		view.id("tabControlInfo1").set("visible",false);
		view.id("tabControlInfo4").set("visible",false);
	}else {
		// 表单对应的dataset更新
		dsHolder.clear();
		dsHolder.set("parameter", view.id("datagridTurretComponent").getCurrentItem().get("shankDrawingno")).flushAsync();
		
		// 表单显示
		view.id("tabControlInfo4").set("visible",true);
		
		view.id("tabControlInfo2").set("visible",false);
		view.id("tabControlInfo3").set("visible",false);
		view.id("tabControlInfo1").set("visible",false);
	}
};

// 零件组件信息对话框预览二维图===钳臂组件
// @Bind #buttonOpenDrawing1.onClick
!function() {
	var msg = "${servletContext.getAttribute('configprop').get('TURRETARM2D_PATH')}";
	//alert(msg);
	view.id("image").set("image",msg
			+ view.id("datagridTurretComponent").getCurrentItem().get(
			"armComponentno") + ".jpg");
	view.id("dialog2DDrawing").show();
};


// 零件组件信息对话框下载三维数模===钳臂组件
// @Bind #buttonDownloadFile1.onClick
!function() {
	dorado.MessageBox.confirm("确认下载钳臂组件三维数模？", function() {
		var armComponentno = view.id("datagridTurretComponent").getCurrentItem().get("armComponentno");
		var armComponentnoMap = new dorado.util.Map();
		armComponentnoMap.put("armComponentno", armComponentno);
		view.id("download3DCompOrPart").set("fileProvider","nimakDownloadService#downloadTurretArmCompFiles");
		view.id("download3DCompOrPart").set("parameter", armComponentnoMap).execute();
	});
};


//零件组件信息对话框预览二维图===电极握杆组件
//@Bind #buttonOpenDrawing2.onClick
!function() {
	var msg = "${servletContext.getAttribute('configprop').get('TURRETARM2D_PATH')}";
	//alert(msg);
	view.id("image").set("image",msg
			+ view.id("datagridTurretComponent").getCurrentItem().get(
			"shankComponentno") + ".jpg");
	view.id("dialog2DDrawing").show();
};


//零件组件信息对话框下载三维数模===电极握杆组件
//@Bind #buttonDownloadFile2.onClick
!function() {
	dorado.MessageBox.confirm("确认下载电极握杆组件三维数模？", function() {
		var shankComponentno = view.id("datagridTurretComponent").getCurrentItem().get("shankComponentno");
		var shankComponentnoMap = new dorado.util.Map();
		shankComponentnoMap.put("shankComponentno", shankComponentno);
		view.id("download3DCompOrPart").set("fileProvider","nimakDownloadService#downloadTurretArmCompFiles");
		view.id("download3DCompOrPart").set("parameter", shankComponentnoMap).execute();
	});
};


//零件组件信息对话框预览二维图===钳臂零件
//@Bind #buttonOpenDrawing3.onClick
!function() {
	var msg = "${servletContext.getAttribute('configprop').get('TURRETARM2D_PATH')}";
	//alert(msg);
	view.id("image").set("image",msg
			+ view.id("datagridTurretComponent").getCurrentItem().get(
			"armDrawingno") + ".jpg");
	view.id("dialog2DDrawing").show();	
};


//零件组件信息对话框下载三维数模===钳臂零件
//@Bind #buttonDownloadFile3.onClick
!function() {
	dorado.MessageBox.confirm("确认下载钳钳臂零件三维数模？", function() {
		var armDrawingno = view.id("datagridTurretComponent").getCurrentItem().get("armDrawingno");
		var armDrawingnoMap = new dorado.util.Map();
		armDrawingnoMap.put("armDrawingno", armDrawingno);
		view.id("download3DCompOrPart").set("fileProvider","nimakDownloadService#downloadTurretArmCompFiles");
		view.id("download3DCompOrPart").set("parameter", armDrawingnoMap).execute();
	});
};


//零件组件信息对话框预览二维图===电极握杆零件
//@Bind #buttonOpenDrawing4.onClick
!function() {
	var msg = "${servletContext.getAttribute('configprop').get('TURRETARM2D_PATH')}";
	//alert(msg);
	view.id("image").set("image",msg
			+ view.id("datagridTurretComponent").getCurrentItem().get(
			"shankDrawingno") + ".jpg");
	view.id("dialog2DDrawing").show();
};


//零件组件信息对话框下载三维数模===电极握杆零件
//@Bind #buttonDownloadFile4.onClick
!function() {
	dorado.MessageBox.confirm("确认下载钳电极握杆零件三维数模？", function() {
		var shankDrawingno = view.id("datagridTurretComponent").getCurrentItem().get("shankDrawingno");
		var shankDrawingnoMap = new dorado.util.Map();
		shankDrawingnoMap.put("shankDrawingno", shankDrawingno);
		view.id("download3DCompOrPart").set("fileProvider","nimakDownloadService#downloadTurretArmCompFiles");
		view.id("download3DCompOrPart").set("parameter", shankDrawingnoMap).execute();
	});
};




//@Bind #saveAllAttrInfo.onClick
!function(self,arg) {
	view.id("dialogInfo").show();
};


//@Bind #buttonSaveAll.onClick
!function(self,arg){
	// 先去编码
	//view.id("ajaxActionCode").set("parameter",view.id("autoformAdd").get("entity").toJSON()).execute();
	
	dorado.MessageBox.confirm("确认保存？", function(){
		//view.id("updateactionSave").execute();
		view.id("ajaxActionJudgeStringIsSatisfied").set("parameter",
				view.id("autoFormBasicAttr").get("entity").toJSON()).execute();
	});
};


//@Bind #buttonEditInToolbar.onClick
!function(self, arg) {
	
	if (view.id("autoFormBasicAttr").get("readOnly") == true) {
		view.id("autoFormBasicAttr").set("readOnly",false);
		view.id("buttonSaveAll").set("disabled",false);
		view.id("dialogEditTurretComponent").set("tags", "Modify");
	}else {
		view.id("autoFormBasicAttr").set("readOnly",true);
		view.id("buttonSaveAll").set("disabled",true);
	}
};

//工具栏simplebutton第一条记录
//@Bind #simpleButtonFirstRecord.onClick
!function(self,arg) {
	//alert(1);
	var entityList =   view.id("dsTurretComponent").getData();
	var entityFirst = entityList.getFirst();
	view.id("datagridTurretComponent").setCurrentEntity(entityFirst);
	view.id("autoFormBasicAttr").set("entity",entityFirst);
	//console.log(1);
	view.id("autoFormBasicAttr").refresh();
	
};



//@Bind #ajaxActionLoadAllArmDrawingnos.onSuccess
!function(self,arg) {
	var returnValue = self.get("returnValue");
	console.log(returnValue);
	var itemsTurretArmDrawingnos = new Array();
	itemsTurretArmDrawingnos = self.get("returnValue");
	view.id("listDropDownTurretArmDrawingnos").set("items",itemsTurretArmDrawingnos);
};


//@Bind #ajaxActionLoadAllShankDrawingnos.onSuccess
!function(self,arg) {
	//var returnValue = self.get("returnValue");
	//console.log(returnValue);
	var itemsTurretShankDrawingnos = new Array();
	itemsTurretShankDrawingnos = self.get("returnValue");
	view.id("listDropDownTurretShankDrawingnos").set("items",itemsTurretShankDrawingnos);
};


//@Bind #frame.onLoad
!function(self,arg) {
	if (flag > 0) {
		dorado.widget.NotifyTipManager.notify("File not Exist！文件不存在");
	}
	flag++;
};

//@Bind #frame.onCreate
!function(self,arg) {
	flag = 0;
};




//只有当图号不为空时才能进行上传或者保存等操作
//@Bind #autoformAdd.#armAssemblyno.onBlur
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


//@Bind #datagridTurretComponent.onReady 
!function(self) {
	dorado.TipManager.initTip(self.getDom(), {
		text : self.get("tip"),
		icon: "QUESTION",
		trackMouse: true
	});
};