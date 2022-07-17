import br.com.dio.desafio.dominio.Bootcamp;
import br.com.dio.desafio.dominio.Curso;
import br.com.dio.desafio.dominio.Dev;
import br.com.dio.desafio.dominio.Mentoria;
import java.util.Random;
import java.time.LocalDate;

//Classe onde irá iniciar a execução do programa
public class Main {

    //método principal de execução
    public static void main(String[] args) {

        String[] titulos = {"Formação Java","Formação JS","Curso React","Formação Laravel"};
        String[] descricoes = {
                "Formação Java completa do junior ao senior, tudo o que você precisa aprender para ser um dev completo",
                "Formação JavaScript para Backend utilizando Node.JS, aprenda a liguagem mais utilizada hoje na internet!",
                "Aprenda tudo que o que o React tem a oferecer para FrontEnd.",
                "Formação Laravel completa do junior ao senior, tudo o que você precisa aprender para ser um dev completo"};
        int[] cargaHorarias = {25,25,8,25};

        Curso[] cursos = new Curso[4];

        for(int i = 0 ; i < 4 ; i++){
            cursos[i] = new Curso();
            cursos[i].setTitulo(titulos[i]);
            cursos[i].setDescricao(descricoes[i]);
            cursos[i].setCargaHoraria(cargaHorarias[i]);
        }


        Mentoria mentoriaJava = new Mentoria();
        mentoriaJava.setTitulo("Mentoria Java");
        mentoriaJava.setDescricao("Receba toda ajuda para começar a desenvolver utilizando Java");
        mentoriaJava.setData(LocalDate.now());


        Bootcamp bootcampJava = new Bootcamp();
        bootcampJava.setNome("Bootcamp Java Developer");
        bootcampJava.setDescricao("Uma semana intensa de programação em Java para você mergulhar nessa tecnologia que move o mundo digital");
        bootcampJava.getConteudos().add(cursos[0]);
        bootcampJava.getConteudos().add(cursos[1]);
        bootcampJava.getConteudos().add(mentoriaJava);

        Mentoria mentoriaLaravel = new Mentoria();
        mentoriaLaravel.setTitulo("Mentoria Laravel");
        mentoriaLaravel.setDescricao("Receba toda ajuda para começar a desenvolver utilizando Java");
        mentoriaLaravel.setData(LocalDate.now());


        Bootcamp bootcampLaravel = new Bootcamp();
        bootcampLaravel.setNome("Bootcamp Laravel Developer");
        bootcampLaravel.setDescricao("Uma semana intensa de programação em PHP para você mergulhar nessa tecnologia que domina o mundo backend");
        bootcampLaravel.getConteudos().add(cursos[2]);
        bootcampLaravel.getConteudos().add(cursos[3]);
        bootcampLaravel.getConteudos().add(mentoriaLaravel);

        Dev[] devs = new Dev[3];
        String[] nomes = {"Diego","Camila","Roberto"};

        Random random = new Random();
        int numeroMagico = 0;
        for(int i = 0 ; i < 3 ; i++){
            devs[i] = new Dev();
            if(numeroMagico <= 1 ){
                devs[i].setNome(nomes[i]);
                devs[i].inscreverBootcamp(bootcampJava);
            } else {
                devs[i].setNome(nomes[i]);
                devs[i].inscreverBootcamp(bootcampLaravel);
            }
            for(int j = 0; j < random.nextInt(10);j++){
                devs[i].progredir();
            }
            numeroMagico++;
        }
        System.out.println("Saída:");
        System.out.println("|-------------------------------------------------------------------|");
        for(int i = 0 ; i < 3 ; i++){
            System.out.println("Conteúdos Inscritos " + devs[i].getNome() + " :" + devs[i].getConteudosInscritos());
            System.out.println("Conteúdos Concluidos " + devs[i].getNome() + " :" + devs[i].getConteudosConcluidos());
            System.out.println("Total de XP:" + devs[i].calcularTotalXp());
            System.out.println("|-------------------------------------------------------------------|");
        }
    }

}
