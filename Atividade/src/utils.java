public class utils {
    public static int getValidOption(int min, int max) {
        boolean invalid_option = false;
        int opcao = 0;
        try {
            opcao = Integer.parseInt(System.console().readLine("=> "));
        } catch (NumberFormatException e) {
            invalid_option = true;
        }

        while (invalid_option || opcao < min || opcao > max) {
            System.out.println("Opção inválida");
            System.out.println("Digite a opção desejada: ");
            invalid_option = false;
            try {
                opcao = Integer.parseInt(System.console().readLine("=> "));
            } catch (Exception e) {
                if (e instanceof NumberFormatException) {
                    invalid_option = true;
                }
            }
        }

        return opcao;
    }

    public static String getValidString() {
        String string = System.console().readLine("=> ");

        String aux = string.replaceAll("\\s+", "");

        while (aux.length() == 0) {
            System.out.println("String inválida");
            System.out.println("Digite novamente: ");
            string = System.console().readLine("=> ");
            aux = string.replaceAll("\\s+", "");
        }

        return string;
    }

    public static int getValidInt() {
        boolean invalid_option = false;
        int value = 0;
        try {
            value = Integer.parseInt(System.console().readLine("=> "));
        } catch (Exception e) {
            if (e instanceof NumberFormatException) {
                invalid_option = true;
            }
        }

        while (invalid_option) {
            System.out.println("Opção inválida");
            System.out.println("Digite a opção desejada: ");
            invalid_option = false;
            try {
                value = Integer.parseInt(System.console().readLine("=> "));
            } catch (NumberFormatException e) {
                invalid_option = true;
            }
        }

        return value;
    }
}
