angular.module('myApp').config(function($stateProvider, $urlRouterProvider) {
	$urlRouterProvider.otherwise('/page-not-found');
	$stateProvider.state('/login', {
		
		url : '/login',
		views : {
			'content@' : {
				templateUrl : 'login.html',
				controller : 'LoginController'
			}
		}
	}).state('login', {
		
		url : '/login',
		views : {
			'content@' : {
				templateUrl : 'login.html',
				controller : 'LoginController'
			}
		}
	}).state('users', {
		
		url : '/users',
		data : {
			role : 'ADMIN'
		},
		views : {
			'content@' : {
				templateUrl : 'users.html',
				controller : 'UsersController'
			}
		}
	}).state('home', {
		
		url : '/',
		views : {
			'content@' : {
				templateUrl : 'product-main-lib.html',
				controller : 'ProductController'
			}
		}
	}).state('page-not-found', {
		
		url : '/page-not-found',
		views : {
			'content@' : {
				templateUrl : 'page-not-found.html',
				controller : 'PageNotFoundController'
			}
		}
	}).state('register', {
		
		url : '/register',
		views : {
			'content@' : {
				templateUrl : 'register.html',
				controller : 'RegisterController'
			}
		}
	}).state('details', {
        
        url : '/details',
        views : {
            'content@' : {
                templateUrl : 'product-details.html',
                controller : 'ProductController'
            }
        }
    }).state('new-product', {
        
        url : '/new_products',
        views : {
            'content@' : {
                templateUrl : 'product-add.html',
                controller : 'AddProductController'
            }
        }
    }).state('edit', {
        
        url : '/edit',
        views : {
            'content@' : {
                templateUrl : 'product-edit.html',
                controller : 'EditProductController'
            }
        }
    }).state('productList', {
        
        url : '/productList',
        views : {
            'content@' : {
                templateUrl : 'user-productList.html',
                controller : 'ProductlistController'
            }
        }
    });
});
