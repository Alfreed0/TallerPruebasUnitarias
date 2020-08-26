package Objetos;

import org.junit.Test;
import static org.junit.Assert.*;

public class EmployeeTest {

    public EmployeeTest() {
    }


    //Test para corrobar si pasando el parametro currency en minusculas sigue tomando el valor del salario completo para Worker
    //Con un buen funcionamiento deberia retornar 2750.0 , el salario completo del trabajador, acorde con el currency dado
    @Test
    public void CurrencyTestCs() {
        Employee instance = new Employee(2750.0F, "usd", 15.0F, EmployeeType.Worker);
        float expResult = 2750.0F;
        float result = instance.cs();
        assertEquals(expResult, result, 0.0);
    }
    
    //Test para corrobar si pasando el parametro currency como null el metodo resta el 5% del salario
    //Con un buen funcionamiento deberia retornar 712.5 , ya que como tal el currency no es USD por lo que
    //Independientemente del currency si este es diferente de USD se deberia descontar el 5%
    @Test
    public void NullCurrencyTestCs() {
        Employee instance = new Employee(750.0F, null, 15.0F, EmployeeType.Worker);
        float expResult = 712.5F;
        float result = instance.cs();
        assertEquals(expResult, result, 0.0);
    }

    //Test para corrobar si pasando el parametro currency en minusculas sigue tomando el valor del bono completo para Supervisor
    //Con un buen funcionamiento deberia retornar 2068.0 acorde con el currency dado
    @Test
    public void CurrencyTestCalculateYearBonus() {
        Employee instance = new Employee(1875.0F, "usd", 18.0F, EmployeeType.Supervisor);
        float expResult = 2068.0F;
        float result = instance.CalculateYearBonus();
        assertEquals(expResult, result, 0.0);
    }
    /**
	 * Este caso de prueba sirve para corroborar si se entrega el sueldo del Manager
	 *  con el tipo de Moneda USD funciona como es el esperado para un mes par.
	 */
  @Test 
  public void testCSManagerUSD(){
	    Employee Manager = new Employee(1000F,"USD",10.0F,EmployeeType.Manager);
	    float salarioManager = Manager.cs();
	    assertEquals(1007.0F,salarioManager,0.0);
	}
  /**
   * En este caso de prueba verificamos si al ingresar una moneda que no es USD realiza bien el cambio
   * de moneda y funcionando para el mes par como debe ser
   * Entrada de salario: 1000F
   * Salida esperada: 953.5F
   */
  
  @Test
  public void testCSManagerCUC(){
      Employee manager = new Employee(1000F,"CUC",10.0F,EmployeeType.Manager);
      float salarioManager = manager.cs();
      assertEquals(957F,salarioManager,0.0);
  }
  /**
   * Este caso de prueba sirve para corrobar si el bonus de un Manager con el tipo de Moneda USD funciona correctamente.
   */
  @Test
  public void testCalculateBonusSManagerUSD(){
	    Employee Manager = new Employee(1000F,"USD",10.0F,EmployeeType.Manager);
	    float salarioManager = Manager.CalculateYearBonus();
	    assertEquals(1386.0F,salarioManager,0.0);
	}
  /**
   * Este caso de prueba sirve para corrobar si el bonus de un Manager con otro tipo de moneda que no es USD funciona correctamente
   * mediante la resta del 5 porciento debido al cambio de moneda.
   */
  @Test
  public void testCalculateBonusSManager(){
	    Employee Manager = new Employee(1000F,"EUR",10.0F,EmployeeType.Manager);
	    float salarioManager = Manager.CalculateYearBonus();
	    assertEquals(1336.0F,salarioManager,0.0);
	}
    
  /**
   * Se realiza una prueba para corroborar el salario de un empleado si es un mes impar recibe adicionalmente el decimo, recordemos que para 
   * la moneda en USD recibe el salario completo
   */
  @Test
    public void testCSworkerUSD() {
        Employee worker = new Employee(1000.0F, "USD", 10.0F, EmployeeType.Worker);
        float workerSalario = worker.cs();
        assertEquals(1000.0F, workerSalario, 0.0);
    }
    /**
   * Se realiza una prueba para corroborar el salario de un empleado de tipo Worker,si es un mes impar recibe adicionalmente el decimo, recordemos que para la moneda
   * que no sea USD recibe el 95% de su salario inicial
   */
    @Test
    public void testCSworkerOtraMoneda() {
        Employee worker = new Employee(1000.0F, "EUR", 10.0F, EmployeeType.Worker);
        float workerSalario = worker.cs();
        assertEquals(950.0F, workerSalario, 0.0); 
            
    }       
   /**
    * Se realiza una prueba para corroborar el salario de un empleado de tipo Supervisor este recibe ademas de su salario un bono y si es un mes impar recibe adicionalmente el decimo,
    * recordemos que para la moneda que no sea "USD" recibe el 95% de su salario inicial.
    */         
   
    @Test
    public void testCSSupervisorOtraMoneda() {
        Employee supervisor = new Employee(1000.0F, "CUC", 10.0F, EmployeeType.Supervisor);
        float salarioSupervisor = supervisor.cs();
        assertEquals(953.5F, salarioSupervisor, 0.0);
    }
    
    
    
    
    
    
    /**
     * Calculando el bono a un supervisor en otra moneda para ver si acepta otras monedas para que pueda hacer el cambio
     * Entrada de salario: 1000F
     * Entrada de Bono: 10F
     * Salida esperada: 1143.0F
     */
    @Test
    public void testCalculateBonusSupervisorCUC(){
        Employee supervisor = new Employee(1000.0F,"CUC",10.0F,EmployeeType.Supervisor);
        float salarioSupervisor = supervisor.CalculateYearBonus();
        assertEquals(1143.0F,salarioSupervisor,0.0);
    }
    
    /**
     * Para poder realizar este metodo cambiamos el mes de la computadora a el mes de julio, un mes impar por lo que podremos
     * verificar si este metodo tambien funciona para los meses impares
     */
    @Test
    public void testCalculateCDManagerMesImpar(){
        Employee manager = new Employee(1000.0F,"CUC",10.0F,EmployeeType.Manager);
        float salarioManager = manager.cs();
        assertEquals(1021.3333129882812,salarioManager,0.0);
    }
    
}
