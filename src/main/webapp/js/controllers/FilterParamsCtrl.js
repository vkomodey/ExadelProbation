/**
 * Created by Administrator on 07.08.2014.
 */
/*var filterParamsCtrl = studentsControllers.controller('filterParamsCtrl', ['$scope', '$routeParams','filterParamsFactory', '$q', function($scope,$routeParams,filterParamsFactory,  $q) {

    filterParamsFactory.getFilterParams(function(data) {
        $scope.filterParams = data;

        $scope.filterItemF={
            techname: $scope.filterParams.technames[0]
        };
        /*$scope.customFilterTech  = function (studentsList) {
         if(studentsList.work.currentUsedTechnologies === null && $scope.filterItem.techname.name!== 'Show All'){
         return false;
         }else{ if(studentsList.work.currentUsedTechnologies=== null && $scope.filterItem.techname.name ==='Show All'){
         return true;
         }else{
         if ( studentsList.work.currentUsedTechnologies=== $scope.filterItem.techname.name) {
         return true;
         } else if ($scope.filterItem.techname.name ==='Show All') {
         return true;
         } else {
         return false;
         }}}

         };

    });

}]);
*/