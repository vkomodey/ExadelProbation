/**
 * Created by Administrator on 04.08.2014.
 */
var studentsApp = angular.module('studentsApp',['ngRoute', 'studentsControllers', 'studentsServices']);
var studentsControllers = angular.module('studentsControllers',['ngTable']);
studentsServices = angular.module('studentsServices',['ngResource']);

