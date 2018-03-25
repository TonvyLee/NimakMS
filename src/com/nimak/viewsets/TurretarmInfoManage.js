
/**
 * RadioGroupImageType
 */
//@Bind #RadioGroupImageType.onClick
!function(self,arg){
	var selectType = view.get("#autoformTurretarmImageType").get("entity").get("autoformTurretarmImageTypeElement");
	
	switch(selectType){
		case 'Cu':
			view.get("#image11").set("image","images/2D/Cu/1-1.jpg");
			view.get("#image12").set("image","images/2D/Cu/1-2.jpg");
			view.get("#image21").set("image","images/2D/Cu/2-1.jpg");
			view.get("#image22").set("image","images/2D/Cu/2-2.jpg");
			view.get("#image31").set("image","images/2D/Cu/3-1.jpg");
			view.get("#image32").set("image","images/2D/Cu/3-2.jpg");
			view.get("#image41").set("image","images/2D/Cu/4-1.jpg");
			view.get("#image42").set("visible",true);
			view.get("#image42").set("image","images/2D/Cu/4-2.jpg");
			view.get("#image51").set("visible",true);
			view.get("#image52").set("visible",true);
			view.get("#image51").set("image","images/2D/Cu/5-1.jpg");
			view.get("#image52").set("image","images/2D/Cu/5-2.jpg");
		break;
		case 'Al':
			view.get("#image11").set("image","images/2D/Al/1-1.jpg");
			view.get("#image12").set("image","images/2D/Al/1-2.jpg");
			view.get("#image21").set("image","images/2D/Al/2-1.jpg");
			view.get("#image22").set("image","images/2D/Al/2-2.jpg");
			view.get("#image31").set("image","images/2D/Al/3-1.jpg");
			view.get("#image32").set("image","images/2D/Al/3-2.jpg");
			view.get("#image41").set("image","images/2D/Al/3-3.jpg");
			view.get("#image42").set("visible",false);
			view.get("#image51").set("image","images/2D/Al/4-1.jpg");
		    view.get("#image52").set("image","images/2D/Al/4-2.jpg");
		break;
		default:
		break;
	}
};


/**
 * RadioGroupTypeCondition
 */
//@Bind #RadioGroupTypeCondition.onClick
!function(self,arg){
	var armStandard = view.get("#autoformQueryForCondition").get("entity").get("armStandard");
	var entity = view.get("#autoformTurretarm").get("entity").set("armStandard",armStandard);
	view.get("#dataSetTurretarm").set("parameter",entity).flushAsync();
	
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
//@Bind #datagridTurretarm.onContextMenu
!function(self, arg, menuCheckTurretArmInfo) {
	menuCheckTurretArmInfo.show({
		position : {
			left : arg.event.pageX,
			top : arg.event.pageY
		}
	});
};
/*------------------------------------------------------------------------------------------------------*/
//@Bind #menuCheckTurretArmInfo.onClick
!function(self, arg, dialogInfo) {
	dialogInfo.show();
};
/*-------------------------------------------------------------------------------------------------------*/
//根据2D视图进行快速查找
//@Bind #image11.onClick
//@Bind #menuitemQuery11.onClick
!function(self, arg) {
	var armType=view.get("#autoformTurretarmImageType").get("entity").get("autoformTurretarmImageTypeElement");
	var entity=view.get("#autoformTurretarm").get("entity").set("armSerial","1-1");
	var entity2 = view.get("#autoformTurretarm").get("entity").set("armType",armType);
	var entity3 = $.extend(entity, entity2);
	view.get("#dataSetTurretarm").set("parameter",entity3).flushAsync();
};
//@Bind #image12.onClick
//@Bind #menuitemQuery12.onClick
!function(self, arg) {
	var armType=view.get("#autoformTurretarmImageType").get("entity").get("autoformTurretarmImageTypeElement");
	var entity=view.get("#autoformTurretarm").get("entity").set("armSerial","1-2");
	var entity2 = view.get("#autoformTurretarm").get("entity").set("armType",armType);
	var entity3 = $.extend(entity, entity2);
	view.get("#dataSetTurretarm").set("parameter",entity3).flushAsync();
};
//@Bind #image21.onClick
//@Bind #menuitemQuery21.onClick
!function(self, arg) {
	var armType=view.get("#autoformTurretarmImageType").get("entity").get("autoformTurretarmImageTypeElement");
	var entity=view.get("#autoformTurretarm").get("entity").set("armSerial","2-1");
	var entity2 = view.get("#autoformTurretarm").get("entity").set("armType",armType);
	entity3 = $.extend(entity, entity2);
	view.get("#dataSetTurretarm").set("parameter",entity3).flushAsync();
};
//@Bind #image22.onClick
//@Bind #menuitemQuery22.onClick
!function(self, arg) {
	var armType=view.get("#autoformTurretarmImageType").get("entity").get("autoformTurretarmImageTypeElement");
	var entity=view.get("#autoformTurretarm").get("entity").set("armSerial","2-2");
	var entity2 = view.get("#autoformTurretarm").get("entity").set("armType",armType);
	entity3 = $.extend(entity, entity2);
	view.get("#dataSetTurretarm").set("parameter",entity3).flushAsync();
};
//@Bind #image31.onClick
//@Bind #menuitemQuery31.onClick
!function(self, arg) {
	var armType=view.get("#autoformTurretarmImageType").get("entity").get("autoformTurretarmImageTypeElement");
	var entity=view.get("#autoformTurretarm").get("entity").set("armSerial","3-1");
	var entity2 = view.get("#autoformTurretarm").get("entity").set("armType",armType);
	entity3 = $.extend(entity, entity2);
	view.get("#dataSetTurretarm").set("parameter",entity3).flushAsync();
};
//@Bind #image32.onClick
//@Bind #menuitemQuery32.onClick
!function(self, arg) {
	var armType=view.get("#autoformTurretarmImageType").get("entity").get("autoformTurretarmImageTypeElement");
	var entity=view.get("#autoformTurretarm").get("entity").set("armSerial","3-2");
	var entity2 = view.get("#autoformTurretarm").get("entity").set("armType",armType);
	entity3 = $.extend(entity, entity2);
	view.get("#dataSetTurretarm").set("parameter",entity3).flushAsync();
};
//@Bind #image41.onClick
//@Bind #menuitemQuery41.onClick
!function(self, arg) {
	var armType=view.get("#autoformTurretarmImageType").get("entity").get("autoformTurretarmImageTypeElement");
	var entity=view.get("#autoformTurretarm").get("entity").set("armSerial","4-1");
	var entity2 = view.get("#autoformTurretarm").get("entity").set("armType",armType);

	switch(armType){
	case 'Cu':
		entity3 = $.extend(entity, entity2);
		view.get("#dataSetTurretarm").set("parameter",entity3).flushAsync();
	break;
	case 'Al':
		var entity=view.get("#autoformTurretarm").get("entity").set("armSerial","3-3");
		entity3 = $.extend(entity, entity2);
		view.get("#dataSetTurretarm").set("parameter",entity3).flushAsync();
	break;
	/*default:
		var entity=view.get("#autoformTurretarm").get("entity").set("armType","Cu");
		view.get("#dataSetTurretarm").set("parameter",entity).flushAsync();
	break;*/
}
	
};
//@Bind #image42.onClick
//@Bind #menuitemQuery42.onClick
!function(self, arg) {
	var armType=view.get("#autoformTurretarmImageType").get("entity").get("autoformTurretarmImageTypeElement");
	var entity=view.get("#autoformTurretarm").get("entity").set("armSerial","4-2");
	var entity2 = view.get("#autoformTurretarm").get("entity").set("armType",armType);
	
	switch(armType){
	case 'Cu':
		entity3 = $.extend(entity, entity2);
		view.get("#dataSetTurretarm").set("parameter",entity3).flushAsync();
	break;
	case 'Al':
		
	break;
	/*default:
		var entity=view.get("#autoformTurretarm").get("entity").set("armType","Cu");
		view.get("#dataSetTurretarm").set("parameter",entity).flushAsync();
	break;*/
};
};
//@Bind #image51.onClick
//@Bind #menuitemQuery51.onClick
!function(self, arg) {
	var armType=view.get("#autoformTurretarmImageType").get("entity").get("autoformTurretarmImageTypeElement");
	var entity=view.get("#autoformTurretarm").get("entity").set("armSerial","5-1");
	var entity2 = view.get("#autoformTurretarm").get("entity").set("armType",armType);
	
	switch(armType){
	case 'Cu':
		entity3 = $.extend(entity, entity2);
		view.get("#dataSetTurretarm").set("parameter",entity3).flushAsync();
	break;
	case 'Al':
		var entity=view.get("#autoformTurretarm").get("entity").set("armSerial","4-1");
		entity3 = $.extend(entity, entity2);
		view.get("#dataSetTurretarm").set("parameter",entity3).flushAsync();
	break;
	/*default:
		var entity=view.get("#autoformTurretarm").get("entity").set("armType","Cu");
		view.get("#dataSetTurretarm").set("parameter",entity).flushAsync();
	break;*/
};
};
//@Bind #image52.onClick
//@Bind #menuitemQuery52.onClick
!function(self, arg) {
	var armType=view.get("#autoformTurretarmImageType").get("entity").get("autoformTurretarmImageTypeElement");
	var entity=view.get("#autoformTurretarm").get("entity").set("armSerial","5-2");
	var entity2 = view.get("#autoformTurretarm").get("entity").set("armType",armType);
	
	switch(armType){
	case 'Cu':
		entity3 = $.extend(entity, entity2);
		view.get("#dataSetTurretarm").set("parameter",entity3).flushAsync();
	break;
	case 'Al':
		var entity=view.get("#autoformTurretarm").get("entity").set("armSerial","4-2");
		entity3 = $.extend(entity, entity2);
		view.get("#dataSetTurretarm").set("parameter",entity3).flushAsync();
	break;
	/*default:
		var entity=view.get("#autoformTurretarm").get("entity").set("armType","Cu");
		view.get("#dataSetTurretarm").set("parameter",entity).flushAsync();
	break;*/
};
};
/*--------------------------------------------------------------------------------------------------------*/