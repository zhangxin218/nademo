MyApp.controller('LoginController', ['$scope', '$location', '$resource', function($scope, $location, $resource) {
	$scope.login = function () {
		var actions = {
				'getToken':{
					method:'POST',
			        headers: {
			            "Content-Type": "application/x-www-form-urlencoded",
			            "Accept": "application/json",
			        }
				}
		    };
		var loginResource = $resource('appdemo/portal/v1.0/login', {}, actions);
        var data = "username=" + $scope.username + "&password="
		        + encodeURIComponent($scope.password);
	    loginResource.getToken(data, function(response){
	    	if (!angular.isDefined(response.access_token)) {
	    		$location.url("/device");
	    	}           	
	    });
	};
}]);

/*'use strict';

angular.module('oauthJhipApp')
    .config(function ($stateProvider) {
        $stateProvider
            .state('login', {
                parent: 'account',
                url: '/login',
                data: {
                    roles: []
                },
                views: {
                    'content@': {
                        templateUrl: 'scripts/login/login.html',
                        controller: 'LoginController'
                    }
                }
            });
    })
    .controller('LoginController', function ($rootScope,$location, $scope,Auth,Principal, $http) {
        $scope.verifyCodeUrl = "";
        $scope.user = {};
        $scope.errors = {};

        //初始不显示验证码
        $scope.showVerifyCode = false;
        $scope.verifyCode==''
        	
        $scope.submitState = false;
        
        //锁定前提示用户或锁定后提示用户
        $scope.lastLockError = null;

        $scope.rememberMe = true;
        $timeout(function (){angular.element('[ng-model="username"]').focus();});
        angular.element(document).ready(function(){
            Metronic.init(); // init metronic core components
            Layout.init(); // init current layout
        });
        
        $(document).ready(function() {
            var height = $(window).height();
            $('#login-background').css('height', height - 60);
        });

        $(window).resize(function(){
            var height = $(window).height();
            $('#login-background').css('height', height - 60);
        });
        
        $scope.refresh = function () {
        	$scope.verifyCode = '';
            document.getElementById("tattedcode").src="api/login/tattedcode?date=" + new Date().getTime(); 
        };
       
//        $scope.register = function () {
//            $location.url("/register"); 
//        };
         
        var configRestUrl = $rootScope.SERVER.NSCL.NAME + "/portal/" + $rootScope.VERSION + "/configuration";
        $http.get(configRestUrl).success(function(result) {
            if (angular.isDefined(result.faultPswCodeTimes)) {
                if(result.faultPswCodeTimes == 0) {
                     $rootScope.alwayShowVerifyCode = true;
                     $scope.showVerifyCode = true;
                     document.getElementById("tattedcode").src="api/login/tattedcode?date=" + new Date().getTime();
                }
            }
        });

        if($rootScope.alwayShowVerifyCode) {
            $scope.verifyCodeUrl = "api/login/tattedcode?d=" + new Date().getTime();
            $scope.showVerifyCode = true;
        }

        $scope.$watch($rootScope.alwayShowVerifyCode, function() {
            $scope.showVerifyCode = $rootScope.alwayShowVerifyCode;
            if ($scope.showVerifyCode) {
                document.getElementById("tattedcode").src="api/login/tattedcode?date=" + new Date().getTime();
            }
        });

        $scope.authenticationError = false;
        $scope.loginErrorCode = "";
        if($rootScope.rejection401) {
            $scope.authenticationError = true;
            if ($rootScope.rejectionCode != "") {
                $scope.loginErrorCode = "oauthJhipApp.errormsg." + $rootScope.rejectionCode;    
            } else {
                $scope.loginErrorCode = "oauthJhipApp.errormsg.rejection401";
            }
            
            $rootScope.rejection401 = false;
            $rootScope.rejectionCode = "";
        }
        if($rootScope.passwordExpiration){
        	$scope.authenticationError = true;
        	$rootScope.passwordExpiration = false;
        	$rootScope.rejection401 = false;
        	Principal.initHistory();
        	$scope.loginErrorCode = "oauthJhipApp.errormsg.passwordExpiration";
        }
        
        
        $scope.login = function () {
        	if(!$scope.checkLoginMsg()){
        		return;
        	}
        	$scope.lastLockError = null;
            $scope.rejection401 = false;
            $scope.authenticationError = false;
            if ($scope.showVerifyCode==true && $scope.verifyCode=='') {
                angular.element('[ng-model="verifyCode"]').focus()
                return;
            }
            
            $scope.submitState = true;
            Auth.login({
                username: $scope.username,
                password: $scope.password,
                verifyCode:$scope.verifyCode,
                rememberMe: $scope.rememberMe
            }).then(function (response) {
            	$scope.submitState = false;
            	$scope.lastLockError = null;
            	$scope.authenticationError = false;
                if (!angular.isDefined(response.data.error_code)) {
                	var checkLoginBody={};
//                	if($scope.isInstallPlugin()){
//                		checkLoginBody.clientCode=document.getElementById("Login_Authentication_ActiveX").GenerateRandomNum_interface()
//                	}
//                	UserVerifyCode.checkLoginVerifyCodeSwitch(checkLoginBody,function(result){
//                		$scope.getCurrentConfigAfter(result.loginSwitch == "true");
//                	},function(){
                		$scope.getCurrentConfigAfter(true);
//                	})
                    return;
                }
//                
//                if (response.headers('X-Verify-Code')) {
//                	$scope.showVerifyCode = true;
//                }
//                
//                $scope.checkLocked(response);
//                
//                //验证码错误，必须显示验证码
//                if (response.data.error_code=='100003')
//                {
//                    if ($scope.showVerifyCode==false) {
//                        response.data.error_code = 'VerifyCodeNotFoundException';
//                    }
//                }
                if (response.data.error_code=='50252'){
                    response.data.error_code = 'InvalidGrantException';
                }
//                //缺少验证码，需要输入验证码
//                if(response.data.error_code=='VerifyCodeNotFoundException') {
//                    $scope.showVerifyCode = true;
//                }
//
//                $scope.authenticationError = true;
//                $scope.loginErrorCode = "oauthJhipApp.errormsg." + response.data.error_code;
//                $scope.verifyCode = '';
//                $scope.password = '';
//                if ($scope.showVerifyCode) {
//                    document.getElementById("tattedcode").src="api/login/tattedcode?date=" + new Date().getTime();
//                }
            }).catch(function (response) {
//            	$scope.submitState = false;
            	
//                if (response.headers('X-Verify-Code')) {
//                	$scope.showVerifyCode = true;
//                }
//                
//                $scope.checkLocked(response);
//                
//                $scope.authenticationError = true;
//                
//                if(response.status == 0 || response.status == 407){
//            		$scope.loginErrorCode = "oauthJhipApp.errormsg.DisconnectException";
//            	}else{
//            		if (angular.isDefined(response.data.error_code)) {
//                    	if (response.data.error_code=='50252'){
//                            response.data.error_code = 'InvalidGrantException';
//                        }
//        				$scope.loginErrorCode = "oauthJhipApp.errormsg." + response.data.error_code;
//        			}else{
//        				$scope.loginErrorCode = "oauthJhipApp.errormsg.authentication";
//        			}
//            	}
//                
//                $scope.verifyCode = '';
//                $scope.password = '';
//                if ($scope.showVerifyCode) {
//                    document.getElementById("tattedcode").src="api/login/tattedcode?date=" + new Date().getTime();
//                }
            });
        };
        
        //检查登录信息是否填写完整
       	$scope.checkLoginMsg = function(){
       		if(null == $scope.username || "" == $scope.username || null == $scope.password || "" == $scope.password 
       				|| ($scope.showVerifyCode && (null == $scope.verifyCode || "" == $scope.verifyCode)) || $scope.submitState){
       			return false;
       		}
       		return true;
       	}
        
        $scope.checkLocked = function(response){
        	if(null == response){
        		return;
        	}
        	var lockTime = response.headers('X-Locked-Last');
        	//锁定前提示用户
            if(null != lockTime){
            	$scope.lastLockError = lockTime;
            }
        }
        
//        $scope.forgotPassword = function () {
//            $location.url("/reset_password//"); 
//        };
        
        $scope.searchOnKeyDown = function(e){
        	if(e && e.keyCode == 13){
        		$scope.login();
        	}
        }
        
        //验证成功，则执行 登陆成功的以下步骤-账号密码登陆成功后要做的处理
        $scope.LoginAfter = function(){
        	$('#LoginVerifyCodeView').modal('hide');
//        	Principal.identity(true).then(function(account) {
//       			if(!Principal.isAuthenticated()){
//       				$scope.authenticationError = true;
//       		    	$scope.loginErrorCode = "oauthJhipApp.errormsg.rejection401";
//       		        $rootScope.rejection401 = false;
//       				return;
//       			}
//       	        if(account != null){
//       	        	Account.getPwdExpire(function(result){
//       	        		var restDay = result.restDay;
//           	     		if(restDay <= 0){
//           	     			$rootScope.TimeOutShow = true;
//           	     			$scope.$broadcast("ShowChangePasswordViewMonitor", {"isExpire" : true});
//           	     		}else if(restDay <= 10){
//           	     			$rootScope.TimeOutShow = true;
//           	     			Util.showDialogWindow('checkLastChangeDateView');
//           	     			$scope.tip = $translate.instant("settings.checkChangePwdDateContent",{"restDay":restDay});
//           	     		}else{
//           	     			$rootScope.g_account = account;
           	     			$scope.locationToHome();
//           	     		}
//       	        	});
//       	        }
//       	    }, function(error){
//       	    });
        }
        
        //获取当前配置信息后处理方法
    	$scope.getCurrentConfigAfter = function(smsLoginSwitch){
    		//登录成功后下次不用输验证码
	        if (!$rootScope.alwayShowVerifyCode) {
	            $scope.showVerifyCode = false;
	        }
        	//根据$rootScope.smsLoginSwitch判断是否要验证码安全登陆
//            if(smsLoginSwitch){
//            	$rootScope.$broadcast("UserVerifyCodeMonitor",{"operateType":"login","templateName":"USER_LOGIN"});
//        	}else {
	        	$scope.LoginAfter();
//			}
            return;
    	}
    	
    	//监听获取到校验码事件
    	$scope.$on("UserVerifyCodeEndMonitor",function(event, msg){
    		if(null == msg || msg.operateType != "login"){
    			return;
    		}
    		var loginBody={"verifyCode":msg.verifyCode,"verifyType":msg.verifyType};
    		if(msg.description!=null && msg.description!="" && msg.clientCode!=null && msg.clientCode!=""){
    			loginBody.description=msg.description;
    			loginBody.clientCode=msg.clientCode;
    		}
        	Register.postLoginVerify(loginBody,function(result) {
        		if(Util.getServerErrMsg(result) != 0){
        			return;
        		}
        		$rootScope.$broadcast("UserVerifyCodeCloseMonitor");
    	        Principal.identity(true).then(function(account) {
    	        	$rootScope.g_account = account;
    	        	$scope.LoginAfter();
        		});
            },$scope.getHttpStatusErrMsg);
        })
        
        //判断用户是否已安装插件,是-true，否-false
//        $scope.isInstallPlugin = function () {
//    		$scope.isPluginGetButton=Util.isInstallPlugin();
//    		return $scope.isPluginGetButton;
//        }
    	//判断是否是IE浏览器（包含IE11），true-是，false-不是
    	$scope.isIE = function () {
    		 return Util.isIE();
    	}
    	
    	$scope.locationToHome = function(){
            $rootScope.initSessionTimeOut();
            $rootScope.showWarningInfo();
        }
    	
    	$scope.$on("UserVerifyCodeTimeOutMonitor",function(event, msg){
    		$scope.getHttpStatusErrMsg(msg)
    	})
    	
    	$scope.getHttpStatusErrMsg = function(httpResponse) {
        	if(angular.isObject(httpResponse) && angular.isDefined(httpResponse.status)){
    	        if (httpResponse.status == 401) {
    	        	var title = Util.getTranslateValue("oauthJhipApp.errormsg.errorTitle");
    	            var error_desc = Util.getTranslateValue("oauthJhipApp.errormsg.100017");
    	        	if (angular.isDefined(httpResponse.data) && angular.isDefined(httpResponse.data.error_code)) {
    	        		error_desc = Util.getTranslateValue("oauthJhipApp.errormsg." + httpResponse.data.error_code);  
    	            }
    	            Auth.logout();
    	            $rootScope.$broadcast("UserVerifyCodeCloseMonitor");
    	            Util.showErrorDialog(title,error_desc);
    	            $scope.verifyCode = '';
                    $scope.password = '';
                    if ($scope.showVerifyCode) {
                        document.getElementById("tattedcode").src="api/login/tattedcode?date=" + new Date().getTime();
                    }
    	        }else{
    	        	Util.getHttpStatusErrMsg(httpResponse);
    	        }
        	}
        };
    });
*/