var timer = null;
MyApp.controller('DeviceController', ['$scope', '$location', '$resource', function($scope, $location, $resource) {
	clearInterval(timer);
	
	var actions = {
			'showMsg':{
				method:'POST',
		        headers: {
		            "Content-Type": "application/x-www-form-urlencoded",
		            "Accept": "application/json",
		        }
			}
	    };
	 var msgResource = $resource('/appdemo/portal/v1.0/show/message', {}, actions);
	 timer = setInterval(function(){
		 msgResource.showMsg({}, function(response){
			 $scope.message = response;
//			 $("#message").html(response);
	    });
	 },500);
}]);