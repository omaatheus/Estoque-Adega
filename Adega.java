import javax.swing.JOptionPane;

public class Adega {
    public static void main(String[] args) {

        char[] tiposVinho = new char[100];
        int contador = 0;

        for (int i = 0; i < tiposVinho.length; i++) {
            String entrada = JOptionPane.showInputDialog(null,
                    "Digite o tipo de vinho ('T' para Tinto, 'B' para Branco, 'R' para Rosé, " +
                            "'F' para finalizar):",
                    "Estoque de Vinhos", JOptionPane.QUESTION_MESSAGE);
            if (entrada == null || entrada.equalsIgnoreCase("F")) {
                break;
            }
            char tipo = entrada.toUpperCase().charAt(0);
            if (tipo == 'T' || tipo == 'B' || tipo == 'R') {
                tiposVinho[contador] = tipo;
                contador++;
            } else {
                JOptionPane.showMessageDialog(null, "Tipo inválido! Por favor, insira 'T', 'B', 'R', ou 'F' para finalizar.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }

        int tinto = 0, branco = 0, rose = 0;

        for (int i = 0; i < contador; i++) {
            switch (tiposVinho[i]) {
                case 'T':
                    tinto++;
                    break;
                case 'B':
                    branco++;
                    break;
                case 'R':
                    rose++;
                    break;
            }
        }

        double percTinto = (tinto * 100.0) / contador;
        double percBranco = (branco * 100.0) / contador;
        double percRose = (rose * 100.0) / contador;

        StringBuilder resultado = new StringBuilder();
        resultado.append("Levantamento do Estoque de Vinhos:\n");
        resultado.append("Total de vinhos: ").append(contador).append("\n");
        resultado.append("Tinto: ").append(tinto).append(" vinhos (").append(String.
                format("%.2f", percTinto)).append("%)\n");
        resultado.append("Branco: ").append(branco).append(" vinhos (").append(String.
                format("%.2f", percBranco)).append("%)\n");
        resultado.append("Rosé: ").append(rose).append(" vinhos (").append(String.
                format("%.2f", percRose)).append("%)\n");

        JOptionPane.showMessageDialog(null, resultado.toString(), "Relatório de Estoque",
                JOptionPane.INFORMATION_MESSAGE);
    }
}