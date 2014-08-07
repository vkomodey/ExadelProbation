studentsServices.factory('filterParamsFactory',['$resource','$routeParams', function($resource,$routeParams) {
    return $resource('/rest/filter/everything', {}, {
        getFilterParams: {method: 'GET', isArray: false}
    });
}]);