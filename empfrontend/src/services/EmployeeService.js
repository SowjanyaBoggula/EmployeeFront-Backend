import axios from 'axios';
const RESTURL="http://localhost:8080/api/employee";

class EmployeeService
{
    getEmployees()
    {
        return axios.get(RESTURL);
    }
    createEmployee(employee)
    {
        return axios.post(RESTURL,employee)
    }
    getEmployeeById(employeeId)
    {
        return axios.get(RESTURL+'/'+employeeId);
    }
    deleteEmployee(employeeId)
    {
        return axios.delete(RESTURL+'/'+employeeId);
    }
    updateEmployee(employee, employeeId)
    {
        return axios.put(RESTURL+'/'+employeeId, employee);
    }

}
export default new EmployeeService();