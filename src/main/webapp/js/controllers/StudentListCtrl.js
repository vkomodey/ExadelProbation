/**
 * Created by Administrator on 04.08.2014.
 */
var StudentListCtrl =  studentsControllers.controller('StudentListCtrl',[
    '$scope','$filter','$routeParams','studentsListFactory', 'ngTableParams','$q','studentsList','$interval',
    function( $scope, $filter,$routeParams, studentsListFactory, ngTableParams, $q,studentsList,$interval) {
        $scope.reloadList = function() {
            var deferred = $q.defer();
            studentsListFactory.getStudentsList(function (data) {
                    $scope.studentsList = data;
                }
            );
            deferred.resolve($scope.studentsList);
        };
        alert('1');
        /*$interval(function() {
            $scope.reloadList();
        },60000);*/
        $scope.checkedStudArray=[];
        $scope.checkedStud = function(id){
            StudentListCtrl.checkedStud(id,$scope.checkedStudArray);
        };
        $scope.studentsList = studentsList;
        $scope.tableParams = new ngTableParams({
            page: 1,            // show first page
            count: $scope.studentsList.length+1,          // count per page
            filter: {
                fio: ''     // initial filter

            },
            sorting: {
                surname: 'asc'     // initial sorting
            }
        }, {
            total: $scope.studentsList.length+1, // length of data
            getData: function ($defer, params) {
                $scope.reloadList();
                var data = $scope.studentsList;
                $defer.resolve(data.slice());
            }, $scope: { studentsList: {} }
        });



        /////////////////////////////////////////////////////////////////////////////////////// LERA STYLE NEXT  ///////////////////////////////////////////////////
        $scope.filterOptions = {
            courses: [
                {   name : 'Show All'},
                {   name : '2 course'},
                {   name : '3 course'},
                {   name : '4 course'},
                {   name : '5 course'},
                {   name : '6 course'}
            ],
            englishlevels: [
                {   name : 'Show All'},
                {   name : 'beginner'},
                {   name : 'elementary'},
                {   name : 'preintermediate'},
                {   name : 'intermediate'},
                {   name : 'upperintermediate'},
                {   name : 'advanced'}
            ],
            workinghours:[
                {name: 'Show All'},
                {name: '20 hours'},
                {name: '30 hours'},
                {name: '40 hours'}
            ],
            salaries:[
                {name: 'Show All'},
                {name: 'billable', state:'true'},
                {name: 'not billable', state:'false'}
            ]
        };
        $scope.filterItem = {
            course: $scope.filterOptions.courses[0],
            workinghour:$scope.filterOptions.workinghours[0],
            englishlevel: $scope.filterOptions.englishlevels[0],
            salary: $scope.filterOptions.salaries[0]

        };

        $scope.customFilterEnglish  = function (studentsList) {
            if(studentsList.english === null && $scope.filterItem.englishlevel.name!== 'Show All'){
                return false;
            }else{ if(studentsList.english=== null && $scope.filterItem.englishlevel.name ==='Show All'){
                return true;
            }else{
                if ( studentsList.english=== $scope.filterItem.englishlevel.name) {
                    return true;
                } else if ($scope.filterItem.englishlevel.name ==='Show All') {
                    return true;
                } else {
                    return false;
                }}}

        };
        $scope.customFilterCourse= function (studentsList) {
            if(studentsList.study.course_group===null && $scope.filterItem.course.name!== 'Show All'){
                return false;
            }else{ if(studentsList.study.course_group===null && $scope.filterItem.course.name ==='Show All'){
                return true;
            }else{
                if ( studentsList.study.course_group[0]=== $scope.filterItem.course.name[0]) {
                    return true;
                } else if ($scope.filterItem.course.name ==='Show All') {
                    return true;
                } else {
                    return false;
                }}}

        };
        $scope.customFilterHours= function (studentsList) {
            if(studentsList.work===null && $scope.filterItem.workinghour.name!== 'Show All'){
                return false;
            }else{ if(studentsList.work===null && $scope.filterItem.workinghour.name ==='Show All'){
                return true;
            }else{
                if(studentsList.work.hours_current===null && $scope.filterItem.workinghour.name!== 'Show All'){
                    return false;
                }else{ if(studentsList.work.hours_current===null && $scope.filterItem.workinghour.name ==='Show All'){
                    return true;
                }else{

                    if ( studentsList.work.hours_current[0]=== $scope.filterItem.workinghour.name[0]) {
                        return true;
                    } else if ($scope.filterItem.workinghour.name ==='Show All') {
                        return true;
                    } else {
                        return false;
                    }}}}}

        };
        $scope.customFilterSalary= function (studentsList) {
            if(studentsList.work===null && $scope.filterItem.salary.name!== 'Show All'){
                return false;
            }else{ if(studentsList.work===null && $scope.filterItem.salary.name ==='Show All'){
                return true;
            }else{
                if(studentsList.work.isBillable===null){
                    if($scope.filterItem.salary.name ==='billable'){
                        return false;
                    }else{
                        return true;
                    }
                }else{
                    if ( studentsList.work.isBillable=== $scope.filterItem.salary.state) {
                        return true;
                    } else if ($scope.filterItem.salary.name ==='Show All') {
                        return true;
                    } else {
                        return false;
                    }
                }
            }
            }

        };

    }]);
StudentListCtrl.studentsList =
    function(studentsListFactory,$q) {
        var deferred = $q.defer();
        studentsListFactory.getStudentsList(function(data){
                deferred.resolve(data);}
        );
        return deferred.promise;
    }
StudentListCtrl.student =
    function(studentsListFactory,$q,$route) {
        var deferred = $q.defer();
        studentsListFactory.getStudent({studId: $route.current.params.studId},function(data){
                deferred.resolve(data);}
        );
        return deferred.promise;
    }
StudentListCtrl.checkedStud = function(id,checkedStudArray) {
    for(var i=0;i<checkedStudArray.length;i++) {
        if(checkedStudArray[i] == id) {
            checkedStudArray.splice(i,1);
            return
        }
    }
    checkedStudArray.push(id);
}