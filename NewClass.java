import java.util.Scanner;

class Fecha { 
    private int dia;
    private int mes;
    private int ano;

    public Fecha(int dia, int mes, int ano) {
        this.dia = dia;
        this.mes = mes;
        this.ano = ano;
    }

    public String fechaCorta() {
        return dia + "/" + mes + "/" + ano;
    }

    public boolean validarFecha() {
        if (mes < 1 || mes > 12) {
            return false;
        }
        if (dia < 1 || dia > diasEnMes(mes, ano)) {
            return false;
        }
        return true;
    }

    public String mesLetra() {
        String[] meses = {"enero", "febrero", "marzo", "abril", "mayo", "junio", "julio", "agosto", "septiembre", "octubre", "noviembre", "diciembre"};
        return meses[mes - 1];
    }

    public String fechaLarga() {
        return dia + " de " + mesLetra() + " de " + ano;
    }

    private int diasEnMes(int mes, int ano) {
        int[] diasPorMes = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (mes == 2 && esBisiesto(ano)) {
            return 29;
        }
        return diasPorMes[mes - 1];
    }

    private boolean esBisiesto(int ano) {
        return (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
    }
}

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el dia:");
        int dia = scanner.nextInt();

        System.out.println("Ingrese el mes:");
        int mes = scanner.nextInt();

        System.out.println("Ingrese el ano:");
        int ano = scanner.nextInt();

        Fecha fecha = new Fecha(dia, mes, ano);

        if (fecha.validarFecha()) {
            System.out.println("La fecha es valida.");
            System.out.println("Fecha en formato largo: " + fecha.fechaLarga());
        } else {
            System.out.println("La fecha es invalida.");
        }
    }
}

