/**
 * Created by Administrator on 07.08.2014.
 */
var ProjectListCtrl = studentsControllers.controller('ProjectListCtrl', [
    '$scope','projectListFactory','projectList','$q',
    function($scope,projectListFactory,projectList,$q) {
        $scope.reloadProjectList = function() {
           var deferred = $q.defer();
            projectListFactory.getProjectList(function(data) {
                $scope.projectList = data;
            });
            deferred.resolve($scope.projectList);
        };
        $scope.projectList = projectList;
        $scope.saveId = function(id){
            $scope.deleteProjectId = id;
        }
    }]);
ProjectListCtrl.projectList = function(projectListFactory,$q) {
    var deferred = $q.defer();
    projectListFactory.getProjectList(function(data) {
        deferred.resolve(data);
    });
    return deferred.promise;
};