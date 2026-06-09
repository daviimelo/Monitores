package org.example.util;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import org.example.facade.InscricaoFacade; // Substituindo Service pela Fachada
import org.example.model.Disciplina;
import org.example.model.Inscricao;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.stream.Collectors;

public class GeradorDeRelatorios {

    private final InscricaoFacade inscricaoFacade;

    // Construtor agora exige a Fachada
    public GeradorDeRelatorios(InscricaoFacade inscricaoFacade) {
        this.inscricaoFacade = inscricaoFacade;
    }

    public void gerarPdfEdital(List<Inscricao> listaInscricoes) throws FileNotFoundException {
        Document documento = new Document(PageSize.A4);

        List<Disciplina> listaDisciplinasDoEdital = listaInscricoes.stream()
                .map(Inscricao::getDisciplina)
                .distinct()
                .collect(Collectors.toList());

        try (OutputStream os = new FileOutputStream("relatório.pdf")) {
            PdfWriter.getInstance(documento, os);
            documento.open();

            Paragraph titulo = new Paragraph("RELATÓRIO DE INSCRIÇÕES\n\n");
            titulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo);

            for (Disciplina disciplina : listaDisciplinasDoEdital) {
                Paragraph nomeDisciplina = new Paragraph(disciplina.getNomeDisciplina(),
                        new Font(Font.FontFamily.HELVETICA, 14, Font.BOLD));
                nomeDisciplina.setSpacingBefore(10);
                documento.add(nomeDisciplina);

                PdfPTable tabela = new PdfPTable(6);
                tabela.setWidthPercentage(100);
                tabela.setSpacingBefore(5);
                tabela.setSpacingAfter(10);

                tabela.addCell("Pos.");
                tabela.addCell("Aluno");
                tabela.addCell("CRE");
                tabela.addCell("Média");
                tabela.addCell("Pontuação");
                tabela.addCell("Status");

                // Chamando a fachada
                List<Inscricao> inscricoesDisciplina = inscricaoFacade.processarResultadoDisciplina(disciplina);

                for (int i = 0; i < inscricoesDisciplina.size(); i++) {
                    Inscricao e = inscricoesDisciplina.get(i);

                    // Chamando a fachada
                    double pontuacao = inscricaoFacade.calcularPontuacao(e);

                    tabela.addCell((i + 1) + "º");
                    tabela.addCell(e.getAluno().getNome());
                    tabela.addCell(String.valueOf(e.getAlunoCRE()));
                    tabela.addCell(String.valueOf(e.getAlunoMedia()));
                    tabela.addCell(String.format("%.2f", pontuacao)); // Formatado com 2 casas
                    tabela.addCell(String.valueOf(e.getResultadoInscricao()).toLowerCase());
                }

                documento.add(tabela);
            }

            documento.close();
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Arquivo não encontrado!");
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar o relatório PDF: " + e.getMessage(), e);
        }
    }
}