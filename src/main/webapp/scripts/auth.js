'use strict';

/**
 * TrainService
 */

MyApp.factory('authService', ['$resource', '$http', function($resource, $http) {
	return new AuthService($resource, $http);
}]);

function AuthService(resource, http) {
 
	var actions = {
		'post':{
			method:'POST',
	        headers: {
	            "Content-Type": "application/x-www-form-urlencoded",
	            "Accept": "application/json",
	        }
		}
    };
	
	this.checkAuth = function(location) {
		
		var TrainResource = resource('/appdemo/portal/v1.0/checkAuth', {}, actions);
		TrainResource.post({}, function(response) {
			console.info(response);
			if (angular.isDefined(response.access_token)) {
				location.url("/login");
	    	}
		});
	};

};