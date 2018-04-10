var flag = 0;
/** @View */
function downloadFile() {
	dorado.MessageBox.confirm("即将开始下载三维数模文件？", function() {
		var gunDrawingno = view.id("datagridTurret").getCurrentItem().get("gunDrawingno");
		var gunDrawingnoMap = new dorado.util.Map();
		gunDrawingnoMap.put("gunDrawingno", gunDrawingno);
		view.id("downloadDrawing").set("parameter", gunDrawingnoMap).execute();
	});
}


// @Bind #view.onReady
!function(self,arg) {
	view.id("ajaxActionLoadAllDrawingnos").execute();
};

// @Bind #dataSet1.onCreate
!function(self, arg) {
	self.insert();
};

// @Bind #dsTurret.onCreate
!function(self, arg) {
	//self.insert();
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
!function(self, autoformCondition, dsTurret) {
	// 获取autoformCondition绑定的实体对象
	var entityJson = autoformCondition.get("entity").toJSON();
	dsTurret.set("parameter", entityJson).flushAsync();
	
	
	// 自动填充下拉框==gunDrawingno===============================================================
	var newItem = autoformCondition.get("entity").get("gunDrawingno");
	var items = new Array();
	var object= view.id("listDropDownGunDrawingno").get("items");
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
	view.id("listDropDownGunDrawingno").set("items",items);
	view.id("gunDrawingnoForm").set("trigger","listDropDownGunDrawingno");
	//==================================================================================
	
	
	// 自动填充下拉框==stroke===============================================================
	var newItemShankCode = autoformCondition.get("entity").get("stroke");
	var itemsShankCode = new Array();
	var objectWidth= view.id("listDropDownStroke").get("items");
	if(objectWidth != null){
		itemsShankCode = Object.values(objectWidth);
	}
	// 数组首位添加元素
	if (newItemShankCode != null && newItemShankCode != "") {
		// 循环遍历元素，如果新添加的元素已经在下拉表中，将原始下拉表中该元素删除。
		for(var i in itemsShankCode) {
			if(newItemShankCode == itemsShankCode[i]) {
				itemsShankCode.remove(itemsShankCode[i]);
			}
		}
		itemsShankCode.unshift(newItemShankCode);
	}
	// 下拉框设置为6各元素
	if (itemsShankCode.length > 6) {
		itemsShankCode.pop();
	}	
	view.id("listDropDownStroke").set("items",itemsShankCode);
	view.id("strokeForm").set("trigger","listDropDownStroke");
	//==================================================================================
	
	// 自动填充下拉框==armAssemblyLength===============================================================
	var newItemShankMaterial = autoformCondition.get("entity").get("armassemblyLength");
	var itemsShankMaterial = new Array();
	var objectLength= view.id("listDropDownArmassemblyLength").get("items");
	if(objectLength != null){
		itemsShankMaterial = Object.values(objectLength);
	}
	// 数组首位添加元素
	if (newItemShankMaterial != null && newItemShankMaterial != "") {
		// 循环遍历元素，如果新添加的元素已经在下拉表中，将原始下拉表中该元素删除。
		for(var i in itemsShankMaterial) {
			if(newItemShankMaterial == itemsShankMaterial[i]) {
				itemsShankMaterial.remove(itemsShankMaterial[i]);
			}
		}
		itemsShankMaterial.unshift(newItemShankMaterial);
	}
	// 下拉框设置为6各元素
	if (itemsShankMaterial.length > 6) {
		itemsShankMaterial.pop();
	}	
	view.id("listDropDownArmassemblyLength").set("items",itemsShankMaterial);
	view.id("armassemblyLengthForm").set("trigger","listDropDownArmassemblyLength");
	//==================================================================================
	
	// 自动填充下拉框==armassemblyWidth===============================================================
	var newItemShankTaper = autoformCondition.get("entity").get("armassemblyWidth");
	var itemsShankTaper = new Array();
	var objectForce= view.id("listDropDownArmassemblyWidth").get("items");
	if(objectForce != null){
		itemsShankTaper = Object.values(objectForce);
	}
	// 数组首位添加元素
	if (newItemShankTaper != null && newItemShankTaper != "") {
		// 循环遍历元素，如果新添加的元素已经在下拉表中，将原始下拉表中该元素删除。
		for(var i in itemsShankTaper) {
			if(newItemShankTaper == itemsShankTaper[i]) {
				itemsShankTaper.remove(itemsShankTaper[i]);
			}
		}
		itemsShankTaper.unshift(newItemShankTaper);
	}
	// 下拉框设置为6各元素
	if (itemsShankTaper.length > 6) {
		itemsShankTaper.pop();
	}	
	view.id("listDropDownArmassemblyWidth").set("items",itemsShankTaper);
	view.id("armassemblyWidthForm").set("trigger","listDropDownArmassemblyWidth");
	//==================================================================================
	
	
	// 自动填充下拉框==armassemblyWidth2===============================================================
	var newItemShankType = autoformCondition.get("entity").get("armassemblyWidth2");
	var itemsShankType = new Array();
	var objectCapAngel= view.id("listDropDownArmassemblyWidth2").get("items");
	if(objectCapAngel != null){
		itemsShankType = Object.values(objectCapAngel);
	}
	// 数组首位添加元素
	if (newItemShankType != null && newItemShankType != "") {
		// 循环遍历元素，如果新添加的元素已经在下拉表中，将原始下拉表中该元素删除。
		for(var i in itemsShankType) {
			if(newItemShankType == itemsShankType[i]) {
				itemsShankType.remove(itemsShankType[i]);
			}
		}
		itemsShankType.unshift(newItemShankType);
	}
	// 下拉框设置为6各元素
	if (itemsShankType.length > 6) {
		itemsShankType.pop();
	}	
	view.id("listDropDownArmassemblyWidth2").set("items",itemsShankType);
	view.id("armassemblyWidth2Form").set("trigger","listDropDownArmassemblyWidth2");
	//==================================================================================
	
	
	// 自动填充下拉框==force===============================================================
	var newItemShankAngel1 = autoformCondition.get("entity").get("force");
	var itemsShankAngel1 = new Array();
	var objectCode= view.id("listDropDownForce").get("items");
	if(objectCode != null){
		itemsShankAngel1 = Object.values(objectCode);
	}
	// 数组首位添加元素
	if (newItemShankAngel1 != null && newItemShankAngel1 != "") {
		// 循环遍历元素，如果新添加的元素已经在下拉表中，将原始下拉表中该元素删除。
		for(var i in itemsShankAngel1) {
			if(newItemShankAngel1 == itemsShankAngel1[i]) {
				itemsShankAngel1.remove(itemsShankAngel1[i]);
			}
		}
		itemsShankAngel1.unshift(newItemShankAngel1);
	}
	// 下拉框设置为6各元素
	if (itemsShankAngel1.length > 6) {
		itemsShankAngel1.pop();
	}	
	view.id("listDropDownForce").set("items",itemsShankAngel1);
	view.id("forceForm").set("trigger","listDropDownForce");
	//==================================================================================
	
	
	// 自动填充下拉框==capAngel===============================================================
	var newItemShankAngel2 = autoformCondition.get("entity").get("capAngel");
	var itemsShankAngel2 = new Array();
	var objectCode2= view.id("listDropDownCapAngel").get("items");
	if(objectCode2 != null){
		itemsShankAngel2 = Object.values(objectCode2);
	}
	// 数组首位添加元素
	if (newItemShankAngel2 != null && newItemShankAngel2 != "") {
		// 循环遍历元素，如果新添加的元素已经在下拉表中，将原始下拉表中该元素删除。
		for(var i in itemsShankAngel2) {
			if(newItemShankAngel2 == itemsShankAngel2[i]) {
				itemsShankAngel2.remove(itemsShankAngel2[i]);
			}
		}
		itemsShankAngel2.unshift(newItemShankAngel2);
	}
	// 下拉框设置为6各元素
	if (itemsShankAngel2.length > 6) {
		itemsShankAngel2.pop();
	}	
	view.id("listDropDownCapAngel").set("items",itemsShankAngel2);
	view.id("capAngelForm").set("trigger","listDropDownCapAngel");
	//==================================================================================
	
	
	
	// 自动填充下拉框==flange===============================================================
	var newItemShankDesigner = autoformCondition.get("entity").get("flange");
	var itemsShankDesigner = new Array();
	var objectShankDesigner= view.id("listDropDownFlange").get("items");
	if(objectShankDesigner != null){
		itemsShankDesigner = Object.values(objectShankDesigner);
	}
	// 数组首位添加元素
	if (newItemShankDesigner != null && newItemShankDesigner != "") {
		// 循环遍历元素，如果新添加的元素已经在下拉表中，将原始下拉表中该元素删除。
		for(var i in itemsShankDesigner) {
			if(newItemShankDesigner == itemsShankDesigner[i]) {
				itemsShankDesigner.remove(itemsShankDesigner[i]);
			}
		}
		itemsShankDesigner.unshift(newItemShankDesigner);
	}
	// 下拉框设置为6各元素
	if (itemsShankDesigner.length > 6) {
		itemsShankDesigner.pop();
	}	
	view.id("listDropDownFlange").set("items",itemsShankDesigner);
	view.id("flangeForm").set("trigger","listDropDownFlange");
	//==================================================================================
	
};

/*
 * if(!self.get("data").getLast()) {
 * //dorado.MessageBox.alert("没有找到满足条件的设计，请重新限定条件查询...");
 * dorado.widget.NotifyTipManager.notify("没有找到满足条件的设计，请重新限定条件查询..."); }
 */

// @Bind #buttonAdd.onClick
// @Bind #buttonAddInToolbar.onClick
!function(self, arg, dialogEditTurret, dsTurret, autoformAdd,uploadFileTipLabel) {
	// id设置为自动加1
	/*
	 * var aa = new Array(); aa = dsTurret.get("data"); var temp = new Array();
	 * var i=1,num=0; aa.each(function(entity){ temp.push(entity.get("id"));
	 * i++; }); num = Math.max.apply(null,temp)+1;
	 */
	// console.log(num);
	dsTurret.insert();
	view.id("updateactionSave").set("userData",null);
	// autoformAdd.get("entity").set("id",num);
	dialogEditTurret.show();
	dialogEditTurret.set("tags", "Add");
	uploadFileTipLabel.set("visible",false);
	
	view.id("buttonSave1").set("disabled",true);
	view.id("buttonUpload2DDrawing").set("disabled",true);
	view.id("buttonUploadDrawing").set("disabled",true);
};

// @Bind #buttonCancel1.onClick
!function(self, dsTurret, dialogEditTurret) {
	dsTurret.get("data:#").cancel();
	dialogEditTurret.hide();
};

// @Bind #buttonSave1.onClick
!function(self, autoformAdd, ajaxActionJudgeStringIsSatisfied) {	
	
	ajaxActionJudgeStringIsSatisfied.set("parameter",
			autoformAdd.get("entity").toJSON()).execute();
};

// @Bind #ajaxActionJudgeStringIsSatisfied.onSuccess
!function(self, updateactionSave) {
	var returnValue = self.get("returnValue");
	if (returnValue == "S_OK") {
		updateactionSave.execute();
	} else {
		dorado.MessageBox.alert(returnValue);
		return;
	}
};

// @Bind #updateactionSave.onSuccess
!function(self, dialogEditTurret) {
	// 如果成功
	dialogEditTurret.hide();
};

// @Bind #datagridTurret.onContextMenu
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
!function(self, ar, dialogInfo, datagridTurret) {
	// imageModelDetail.set("image","images\\ModelDetail\\"+literatureId+".JPG");
	var dialogName = datagridTurret.getCurrentItem().get("gunDrawingno");
	dialogInfo.set("caption", dialogName);
	dialogInfo.show();
};

// 表格右键更多信息对话框关闭按钮
// @Bind #buttonCancel2.onClick
!function(self, ar, dialogInfo, datagridTurret, dsTurret) {
	// imageModelDetail.set("image","images\\ModelDetail\\"+literatureId+".JPG");
	dialogInfo.hide();
	dsTurret.flush();
};

// @Bind #buttonModify.onClick
!function(self, arg, dialogEditTurret,uploadFileTipLabel) {
	dialogEditTurret.show();
	view.id("updateactionSave").set("userData",null);
	dorado.MessageBox.alert("注意：修改模式下上传文件将覆盖原始相关文件!");
	dialogEditTurret.set("tags", "Modify");
	uploadFileTipLabel.set("visible",true);
	
	view.id("buttonSave1").set("disabled",false);
	view.id("buttonUpload2DDrawing").set("disabled",false);
	view.id("buttonUploadDrawing").set("disabled",false);
};

// @Bind #buttonDelete.onClick
!function(self, arg, dialogEdit, dsTurret, updateactionSave,
		ajaxActionDeleteRelatedFiles) {
	var entity = dsTurret.get("data:#");
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



// @Bind #menuItemOpen2DDrawing.onClick
!function(dialog2DDrawing, image) {
	dorado.widget.NotifyTipManager
			.notify("正在为您打开二维图......!");
	var msg = "${servletContext.getAttribute('configprop').get('TURRET2D_PATH')}";
	image.set("image", msg
			+ view.id("datagridTurret").getCurrentItem().get(
					"gunDrawingno") + ".jpg");
	dialog2DDrawing.show();
};

// @Bind #datagridTurret.onCreate
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
									var msg = "${servletContext.getAttribute('configprop').get('TURRET2D_PATH')}";
									image.set("image", msg
											+ self.getCurrentItem().get(
													"gunDrawingno") + ".jpg");
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
	
	
	var OperationCellRenderer2 = $extend(
			dorado.widget.grid.SubControlCellRenderer,
			{
				createSubControl : function(arg) {
					if (arg.data.rowType)
						return null;
					// 返回按钮对象并为按钮对象绑定onClick事件
					return new dorado.widget.Button(
							{
								onClick : function(datagridTurret,treeCompInfo, treeCompInfo,image) {
									// 部件组件零件信息树，自动添加节点
									treeCompInfo.clearNodes();
									var rootNode = treeCompInfo.get("root");
									rootNode.addNode(new dorado.widget.tree.BaseNode({
										label:"静臂部件:"+datagridTurret.getCurrentItem().get("armAssemblynoF"),
										icon : " url(>skin>common/icons.gif) -180px -40px",
									}));
									rootNode.addNode(new dorado.widget.tree.BaseNode({
										label:"动臂部件:"+datagridTurret.getCurrentItem().get("armAssemblynoM"),
										icon : " url(>skin>common/icons.gif) -180px -40px",
									}));
									/*rootNode.addNode(new dorado.widget.tree.BaseNode({
										label:"钳臂零件:"+datagridTurretComponent.getCurrentItem().get("armDrawingno"),
									}));
									rootNode.addNode(new dorado.widget.tree.BaseNode({
										label:"电极握杆零件:"+datagridTurretComponent.getCurrentItem().get("shankDrawingno"),
									}));*/
									// 表单对应的dataset更新
									view.id("dsTurretComp").clear();
									view.id("dsTurretComp").set("parameter", view.id("datagridTurret").getCurrentItem().get("armAssemblynoF")).flushAsync();
									
									view.id("tabControlInfo1").set("visible",true);
									
									view.id("tabControlInfo2").set("visible",false);
									view.id("tabControlInfo3").set("visible",false);
									view.id("tabControlInfo4").set("visible",false);
									view.id("dialogCompInfo").set("caption","焊钳图号为["+view.id("datagridTurret").getCurrentItem().get("gunDrawingno")+"]的钳臂部件信息");
									view.id("dialogCompInfo").show();
								}
							});
				},
				refreshSubControl : function(button, arg) {
					button.set({
						caption : "部件信息",
						icon : "url(>skin>common/icons.gif) -260px -80px",
						style:"margin:0 2px;color:blue",
						disabled : false
					});
					
				}
			});
	self.set("#openComp.renderer", new OperationCellRenderer2());
};

// @Bind #menuItemDownLoad3DFile.onClick
!function(self, downloadDrawing, datagridTurret) {
	dorado.MessageBox.confirm("确认下载三维数模？", function() {
		var gunDrawingno = datagridTurret.getCurrentItem().get("gunDrawingno");
		var gunDrawingnoMap = new dorado.util.Map();
		gunDrawingnoMap.put("gunDrawingno", gunDrawingno);
		view.id("downloadDrawing").set("parameter", gunDrawingnoMap).execute();
	});
};


//@Bind #menuItemDownZip.onClick
!function(self, downloadDrawingZip, datagridTurret) {
	dorado.MessageBox.confirm("确认打包下载三维数模(包含部件、组件数模文件)？", function() {
		var gunDrawingno = datagridTurret.getCurrentItem().get("gunDrawingno");
		var armAssemblynoF = datagridTurret.getCurrentItem().get("armAssemblynoF");
		var armAssemblynoM = datagridTurret.getCurrentItem().get("armAssemblynoM");
		var gunDrawingnoMap = new dorado.util.Map();
		gunDrawingnoMap.put("gunDrawingno", gunDrawingno);
		gunDrawingnoMap.put("armAssemblynoF", armAssemblynoF);
		gunDrawingnoMap.put("armAssemblynoM", armAssemblynoM);
		view.id("downloadDrawingZip").set("parameter", gunDrawingnoMap).execute();
	});
};





// @Bind #buttonUploadDrawing.onClick 
!function(self) {
	if (view.id("dialogEditTurret").get("tags") == "Modify") {
		dorado.widget.NotifyTipManager.notify("确认修改重新上传数模文件？原始数模文件将被覆盖！");
	}
	self.refresh();
	console.log("zenmehuishi");
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
!function(self,arg) {
	if (view.id("dialogEditTurret").get("tags") == "Modify") {
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
	console.log(1);
	if (returnValue == "E_Fail") {
		dorado.MessageBox.alert("上传失败，确保相关参数填写完整！");
	}else {
		var fileName = Value.fileName;
		dorado.MessageBox.alert("文件" + fileName + "成功上传");
	}
};


// @Bind #datagridTurret.onRenderHeaderCell
!function(arg) {
	arg.dom.style.backgroundcolor = "skyblue";
	//arg.dom.style.color = "red";
	arg.dom.style.fontSize = "30";
	arg.dom.style.height = "50";
	arg.processDefault = true;
};



//@Bind #saveAllAttrInfo.onClick
!function(self,arg) {
	view.id("dialogInfo").show();
};


// @Bind #buttonSaveAll.onClick
!function(self,arg){
	view.id("ajaxActionJudgeStringIsSatisfied").set("parameter",
			view.id("autoFormBasicAttr").get("entity").toJSON()).execute();
};


//@Bind #buttonEditInToolbar.onClick
!function(self, arg) {
	if (view.id("autoFormBasicAttr").get("readOnly") == true) {
		view.id("autoFormBasicAttr").set("readOnly",false);
		view.id("buttonSaveAll").set("disabled",false);
	}else {
		view.id("autoFormBasicAttr").set("readOnly",true);
		view.id("buttonSaveAll").set("disabled",true);
	}
};



//@Bind #datagridTurret.#gunDrawingno.onRenderCell
!function(arg) {
	var gunDrawingno = arg.data.get("gunDrawingno");
	arg.dom.innerHTML = "<a href='javascript:view.downloadFile()'>"+gunDrawingno+"</a>";
};

//@Bind #datagridTurret.#gunType.onRenderCell
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


// @Bind #menuItemOpenComp.onClick
!function(self,arg,dialogCompInfo,treeCompInfo,datagridTurret) {
	// 部件组件零件信息树，自动添加节点
	treeCompInfo.clearNodes();
	var rootNode = treeCompInfo.get("root");
	rootNode.addNode(new dorado.widget.tree.BaseNode({
		label:"静臂部件:"+datagridTurret.getCurrentItem().get("armAssemblynoF"),
	}));
	rootNode.addNode(new dorado.widget.tree.BaseNode({
		label:"动臂部件:"+datagridTurret.getCurrentItem().get("armAssemblynoM"),
	}));
	/*rootNode.addNode(new dorado.widget.tree.BaseNode({
		label:"钳臂零件:"+datagridTurretComponent.getCurrentItem().get("armDrawingno"),
	}));
	rootNode.addNode(new dorado.widget.tree.BaseNode({
		label:"电极握杆零件:"+datagridTurretComponent.getCurrentItem().get("shankDrawingno"),
	}));*/
	// 表单对应的dataset更新
	view.id("dsTurretComp").clear();
	view.id("dsTurretComp").set("parameter", view.id("datagridTurret").getCurrentItem().get("armAssemblynoF")).flushAsync();
	
	view.id("tabControlInfo1").set("visible",true);
	
	view.id("tabControlInfo2").set("visible",false);
	view.id("tabControlInfo3").set("visible",false);
	view.id("tabControlInfo4").set("visible",false);
	dialogCompInfo.set("caption","焊钳图号为"+view.id("datagridTurret").getCurrentItem().get("gunDrawingno")+"部件信息");
	dialogCompInfo.show();
};

// @Bind #ajaxActionLoadAllDrawingnos.onSuccess
!function(self,arg) {
	var returnValue = self.get("returnValue");
	console.log(returnValue);
	var itemsTurretCompDrawingnos = new Array();
	itemsTurretCompDrawingnos = self.get("returnValue");
	view.id("listDropDownCompDrawing").set("items",itemsTurretCompDrawingnos);
};



//@Bind #buttonCancelComp.onClick
!function() {
	view.id("dialogCompInfo").hide();
};


//@Bind #treeCompInfo.onDataRowClick
!function(self,dsTurretComp) {
	var currentNode = self.get("currentNode");
	var nodeLabel = currentNode.get("label");
	if(nodeLabel.indexOf("静臂部件") != -1) {
		// 表单对应的dataset更新
		dsTurretComp.clear();
		dsTurretComp.set("parameter", view.id("datagridTurret").getCurrentItem().get("armAssemblynoF")).flushAsync();
		
		// 表单显示
		view.id("tabControlInfo1").set("visible",true);
		
		view.id("tabControlInfo2").set("visible",false);
		view.id("tabControlInfo3").set("visible",false);
		view.id("tabControlInfo4").set("visible",false);
	}else if(nodeLabel.indexOf("动臂部件") != -1) {
		// 表单对应的dataset更新
		dsTurretComp.clear();
		dsTurretComp.set("parameter", view.id("datagridTurret").getCurrentItem().get("armAssemblynoM")).flushAsync();
		
		// 表单显示		
		view.id("tabControlInfo2").set("visible",true);
		
		view.id("tabControlInfo1").set("visible",false);
		view.id("tabControlInfo3").set("visible",false);
		view.id("tabControlInfo4").set("visible",false);
	}
};



//零件组件信息对话框预览二维图===钳臂部件静臂部件
//@Bind #buttonOpenDrawing1.onClick
!function() {
	var msg = "${servletContext.getAttribute('configprop').get('TURRETCOMPONENT2D_PATH')}";
	//alert(msg);
	view.id("image").set("image",msg
			+ view.id("datagridTurret").getCurrentItem().get(
			"armAssemblynoF") + ".jpg");
	view.id("dialog2DDrawing").show();
};


//零件组件信息对话框下载三维数模===钳臂部件静臂部件
//@Bind #buttonDownloadFile1.onClick
!function() {
	dorado.MessageBox.confirm("确认下载静臂部件三维数模？", function() {
		var armAssemblynoF = view.id("datagridTurret").getCurrentItem().get("armAssemblynoF");
		var armAssemblynoFMap = new dorado.util.Map();
		armAssemblynoFMap.put("armAssemblyno", armAssemblynoF);
		view.id("downloadDrawing").set("fileProvider","nimakDownloadService#downloadTurretComponentFile");
		view.id("downloadDrawing").set("parameter", armAssemblynoFMap).execute();
	});
};

//零件组件信息"保存按钮"===钳臂部件静臂部件
//@Bind #buttonSaveComp1.onClick
!function(self,arg) {
	view.id("updateActionSaveComp").execute();
};


//零件组件信息对话框预览二维图===钳臂部件动臂部件
//@Bind #buttonOpenDrawing2.onClick
!function() {
	var msg = "${servletContext.getAttribute('configprop').get('TURRETCOMPONENT2D_PATH')}";
	//alert(msg);
	view.id("image").set("image",msg
			+ view.id("datagridTurret").getCurrentItem().get(
			"armAssemblynoM") + ".jpg");
	view.id("dialog2DDrawing").show();
};


//零件组件信息对话框下载三维数模===钳臂部件动臂部件
//@Bind #buttonDownloadFile2.onClick
!function() {
	dorado.MessageBox.confirm("确认下载静臂部件三维数模？", function() {
		var armAssemblynoM = view.id("datagridTurret").getCurrentItem().get("armAssemblynoM");
		var armAssemblynoMMap = new dorado.util.Map();
		armAssemblynoMMap.put("armAssemblyno", armAssemblynoM);
		view.id("downloadDrawing").set("fileProvider","nimakDownloadService#downloadTurretComponentFile");
		view.id("downloadDrawing").set("parameter", armAssemblynoMMap).execute();
	});
};

// @Bind #frame.onLoad
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
//@Bind #autoformAdd.#gunDrawingno.onBlur
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


//提示信息移动
//@Bind #datagridTurret.onReady 
!function(self) {
	dorado.TipManager.initTip(self.getDom(), {
		text : self.get("tip"),
		icon: "QUESTION",
		trackMouse: true
	});
};
