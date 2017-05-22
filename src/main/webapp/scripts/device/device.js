var timer = null;
MyApp.controller('DeviceController', ['authService','$scope', '$location', '$resource', function(authService, $scope, $location, $resource) {
	var actions = {
		'reg':{
			method:'POST',
	        headers: {
	            "Content-Type": "application/x-www-form-urlencoded",
	            "Accept": "application/json",
	        }
		},
		'find':{
			method:'POST',
			headers: {
				"Content-Type": "application/x-www-form-urlencoded",
				"Accept": "application/json",
			}
		},
		'get':{
			method:'GET',
			headers: {
				"Content-Type": "application/x-www-form-urlencoded",
				"Accept": "application/json",
			}
		},
		'del':{
			method:'DELETE',
			headers: {
				"Content-Type": "application/x-www-form-urlencoded",
				"Accept": "application/json",
			}
		},
		'modify':{
			method:'PUT',
			headers: {
				"Content-Type": "application/x-www-form-urlencoded",
				"Accept": "application/json",
			}
		},
		'send':{
			method:'POST',
			headers: {
				"Content-Type": "application/x-www-form-urlencoded",
				"Accept": "application/json",
			}
		},
		'showMsg':{
			method:'POST',
	        headers: {
	            "Content-Type": "application/x-www-form-urlencoded",
	            "Accept": "application/json",
	        }
		}
    };
	clearInterval(timer);
	
//	authService.checkAuth($location);
	
	 var msgResource = $resource('/appdemo/portal/v1.0/show/message', {}, actions);
	 timer = setInterval(function(){
		 msgResource.showMsg({}, function(response){
			 $scope.message = response.message;
	    });
	 },1000);
	
	$scope.regDevice = function () {
		var deviceResource = $resource('/appdemo/portal/v1.0/reg/device', {}, actions);
        var data = "verifyCode=" + $scope.verifyCode + "&nodeId=" + $scope.nodeId;
        deviceResource.reg(data, function(response){
	    });
        
	};
	
	$scope.findDevice = function(){
		var deviceResource = $resource('/appdemo/portal/v1.0/find/device', {}, actions);
        var data = "findDeviceId=" + $scope.findDeviceId + "&protocolType=" + $scope.protocolType;
        deviceResource.find(data, function(response){
	    });
	};
	
	$scope.queryDeviceStatus = function(){
		var deviceResource = $resource('/appdemo/portal/v1.0/status/device/:deviceId', {}, actions);
		deviceResource.get({deviceId:$scope.deviceId}, function(response){
//			if(response.activated){
//				alert("该设备已激活");
//			}else{
//				alert("该设备未激活");
//			}
		});
	};
	
	$scope.delDevice = function(){
		var deviceResource = $resource('/appdemo/portal/v1.0/delete/device/:deviceId', {}, actions);
		deviceResource.del({deviceId:$scope.delDeviceId}, function(response){
//			if(response.activated){
//				alert("删除设备成功");
//			}else{
//				alert("删除设备失败");
//			}
		});
	};

	$scope.renameDevice = function(){
		var deviceResource = $resource('/appdemo/portal/v1.0/rename/device/:deviceId', {}, actions);
        var data = "deviceName=" + $scope.deviceName + "&endUser=" + $scope.endUser ;
		deviceResource.modify({deviceId:$scope.renameDeviceId,deviceName:$scope.deviceName,endUser:$scope.endUser},{}, function(response){
//			if(response.activated){
//				alert("删除设备成功");
//			}else{
//				alert("删除设备失败");
//			}
		});
	};
	
	$scope.sendCommndToDevice = function(){
		var deviceResource = $resource('/appdemo/portal/v1.0/send/command/device', {}, actions);
		var data = "deviceId=" + $scope.sendDeviceId + "&serviceId=" + $scope.sendServiceId
				+ "&commandName=" + $scope.sendCommandName + "&commandPara=" + $scope.sendCommandPara;
		deviceResource.send(data, function(response){
//			if(response.activated){
//				alert("删除设备成功");
//			}else{
//				alert("删除设备失败");
//			}
		});
	};

	$scope.gotoSearch = function(){
		$location.url("/data");
	};

	$scope.protocolType = "Z-Wave";
}]);