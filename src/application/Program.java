package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Locale.setDefault(Locale.US);

        List<Employee> list = new ArrayList<>();

        // Registro de funcionarios:

        System.out.print("Quantos funcionarios serão registrados? ");
        System.out.println();
        int n = sc.nextInt();

        for (int i=1; i<=n; i++) {
            System.out.println();
            System.out.println("Funcionario #" + i + ": ");

            System.out.print("Id: ");
            int id = sc.nextInt();
            while (hasId(list, id)) {
                System.out.print("Esse Id já existe. Por favor digite outro: ");
                id = sc.nextInt();
            }
            System.out.print("Nome: ");
            sc.nextLine();
            String name = sc.nextLine();
            System.out.print("Salario: ");
            double salary = sc.nextDouble();
            list.add(new Employee(id, name, salary));
        }

        // Aumento de salario:

        System.out.println();
        System.out.print("Entre com o Id do funcionario que recebera aumento: ");
        int id = sc.nextInt();
        Employee emp = list.stream().filter( x -> x.getId() == id).findFirst().orElse(null);
        if (emp == null) {
            System.out.println("Esse Id não existe!");
        }else {
            System.out.print("Entre com a porcentagem: ");
            double percentage = sc.nextDouble();
            emp.increaseSalary(percentage);
        }

        //Lista de funcionarios na empresa:

        System.out.println();
        System.out.println("Lista de Funcionarios: ");
        for (Employee obj : list) {
            System.out.println(obj);
        }

        sc.close();

    }

    public static boolean hasId(List<Employee> list, int id) {
        Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
        return emp != null;
    }
}
