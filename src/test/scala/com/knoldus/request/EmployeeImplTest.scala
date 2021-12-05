package com.knoldus.request

import com.knoldus.models.Employee
import com.knoldus.validator.EmployeeValidator
import org.mockito.MockitoSugar.{mock, when}
import org.scalatest.funsuite.AnyFunSuite

class EmployeeImplTest extends AnyFunSuite{
  val employeeValidator = mock[EmployeeValidator]
  val Gaurav:Employee = new Employee("Gaurav","Kumar",22,15000,"Intern","Knoldus","gaurav.kumar@gmail.com")
  val userImpl = new EmployeeImpl(employeeValidator)

  test("User can be ceated"){
    when(employeeValidator.employeeIsValid(Gaurav)) thenReturn(true)
    val result = userImpl.createEmployee(Gaurav)
    assert(result.isDefined)
  }
  test("User can not be created"){
    when(employeeValidator.employeeIsValid(Gaurav)) thenReturn(false)
    val result = userImpl.createEmployee(Gaurav)
    assert(result.isEmpty)
  }
}