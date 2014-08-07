/**
 * Created by Administrator on 07.08.2014.
 */
var ProjectListCtrl = studentsControllers.controller('ProjectListCtrl', [
    '$scope','projectListFactory','projectList','$q',
    function($scope,projectListFactory,projectList,$q) {
        $scope.reloadProjectList = function() {
            $scope.projectList = ProjectListCtrl.projectList();
        };
        $scope.projectList = projectList;
    }]);
ProjectListCtrl.projectList = function(projectListFactory,$q) {
    var deffered = $q.defer;
    projectListFactory.getProjectList(function(data) {
        deffered.resolve(data);
    });
    return deffered.promise;
};