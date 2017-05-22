MyApp.controller('DataController', ['$scope', '$location', '$resource', 'ngTableParams','$filter', function($scope, $location, $resource, ngTableParams, $filter) {
	var actions = {
			'query':{
				method:'GET',
		        headers: {
		            "Content-Type": "application/x-www-form-urlencoded",
		            "Accept": "application/json",
		        }
			}
    	};

	$scope.formSearchData = {};
	$scope.formSearchData.pageSize = 10;
	$scope.resultDetail = "";
	$scope.taskType = "getDevices";
	$scope.devices = {};
	$scope.historys = {};
	$scope.changeSearchType = function(type){
		$scope.taskType = type;
		$scope.formSearchData = {};
		$scope.formSearchData.pageSize = 10;
	}

	$scope.searchSubmit = function(){
		if($scope.taskType == "getDevices"){
			$scope.initDeviceTable();
		}
		if($scope.taskType == "getHistory"){
			$scope.initTable();
		}
		if($scope.taskType == "getDeviceService"){
			$scope.queryDeviceCapabilities();
		}
		if($scope.taskType == "getDevice"){
			$scope.queryDeviceById();
		}

	}

	$scope.initDeviceTable = function()
	{
		//列表初始化或刷新
		if($scope.deviceTableParams == null)
		{
			$scope.deviceTableParams = new ngTableParams
			({
					page: 1,            // show first page
					count: $scope.formSearchData.pageSize
				},
				{
					counts: [],
					total: $scope.formSearchData.pagesize, // length of data
					getData: function($defer, params)
					{
						$scope.formSearchData.pageNo = params.page()-1;
						$scope.formSearchData.pageSize = params.count();
						//通过后台获取数据
						$scope.queryDevice($defer, params);
					}
				});
		}
		else
		{
			$scope.deviceTableParams.$params.page = 1;
			$scope.deviceTableParams.reload();
		}
	}

	$scope.initTable = function()
	{
		//列表初始化或刷新
		if($scope.tableParams == null)
		{
			$scope.tableParams = new ngTableParams
			({
					page: 1,            // show first page
					count: $scope.formSearchData.pageSize
				},
				{
					counts: [],
					total: $scope.formSearchData.pagesize, // length of data
					getData: function($defer, params)
					{
						$scope.formSearchData.pageNo = params.page()-1;
						$scope.formSearchData.pageSize = params.count();
						//通过后台获取数据
						$scope.queryDeviceHistory($defer, params);
					}
				});
		}
		else
		{
			$scope.tableParams.$params.page = 1;
			$scope.tableParams.reload();
		}
	}

	$scope.queryDevice = function ($defer, params) {
		var devicesResource = $resource('/appdemo/portal/v1.0/data/query/devices', {}, actions);
		//var devicesResource = $resource('/getDevice.json', {}, actions);
        var data = {
			appId:$scope.formSearchData.appId,
			deviceId:$scope.formSearchData.deviceId,
			gatewayId:$scope.formSearchData.gatewayId,
			nodeType:$scope.formSearchData.nodeType,
			status:$scope.formSearchData.status,
			pageNo:$scope.formSearchData.pageNo,
			pageSize:$scope.formSearchData.pageSize,
			startTime:$scope.formSearchData.startTime,
			endTime:$scope.formSearchData.endTime,
			sort:$scope.formSearchData.sort
		}
        devicesResource.query(data, function(response){
			$scope.devices = response.devices;
			params.total(response.totalCount);
			$defer.resolve($scope.devices);
	    });
	};
	
	$scope.queryDeviceHistory = function ($defer, params) {
		var devicesResource = $resource('/appdemo/portal/v1.0/data/query/history/devices', {}, actions);
		var data = {
			deviceId:$scope.formSearchData.deviceId,
			gatewayId:$scope.formSearchData.gatewayId,
			serviceId:$scope.formSearchData.serviceId,
			pageNo:$scope.formSearchData.pageNo,
			pageSize:$scope.formSearchData.pageSize,
			startTime:$scope.formSearchData.startTime,
			endTime:$scope.formSearchData.endTime
		}
		devicesResource.query(data, function(response){
			$scope.historys = response.deviceDataHistoryDTOs;
			params.total(response.totalCount);
			$defer.resolve($scope.historys);
		});
	};

	$scope.queryDeviceById = function () {
		var devicesResource = $resource('/appdemo/portal/v1.0/data/query/device/:deviceId', {}, actions);
		var data = {deviceId:$scope.formSearchData.deviceId}
		devicesResource.query(data, function(response){
        	$scope.resultDetail = JSON.stringify(response,null,4);
		});
	};
	
	$scope.queryDeviceCapabilities = function () {
		var devicesResource = $resource('/appdemo/portal/v1.0/data/query/capabilities', {}, actions);
		var data = {deviceId:$scope.formSearchData.deviceId,
					gatewayId:$scope.formSearchData.gatewayId}
		devicesResource.query(data, function(response){
			$scope.resultDetail = JSON.stringify(response.deviceCapabilities,null,4);
		});
	};
	
	$scope.objToStringDetail = function(obj){
		return JSON.stringify(obj);
	}

	$scope.getDetail = function(data){
		$scope.detailData = JSON.stringify(data,null,4);
		$scope.showDialogWindow('formatDataModal');
	}

	$scope.showDialogWindow = function(id){
		var dialog = $('#' + id);
		if(dialog != null){
			var draggableObj = dialog.find(".modal-dialog");
			if(null != draggableObj){
				draggableObj.css('top', '0px');
				draggableObj.css('left', '0px');
			}
			dialog.modal('show');
		}
	}

}]);