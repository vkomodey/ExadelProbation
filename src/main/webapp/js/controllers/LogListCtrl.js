/**
 * Created by Administrator on 11.08.2014.
 */
var LogListCtrl = studentsControllers.controller('LogListCtrl', ['$scope','LogListFactory','$q', function($scope,LogListFactory,$q) {
    var reloadLogList = function() {
        if($scope.studIdForLog==null) {
            return;
        }
        var deferred = $q.defer();
        LogListFactory.getLogList({studId: $scope.studIdForLog},function(data) {
            $scope.logList = data;
        });
        deferred.resolve($scope.logList);
    };
    $scope.$watch('studIdForLog',function(){
        reloadLogList();
    });
}]);
