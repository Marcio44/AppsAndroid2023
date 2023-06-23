package devandroid.silva.AppListaCurso.Controller;

import java.util.ArrayList;
import java.util.List;

import devandroid.silva.AppListaCurso.Model.Curso;

public class CursoController {

    private List listCurso;

    public List getListaCurso(){

        listCurso = new ArrayList<Curso>();

        listCurso.add(new Curso("Java"));
        listCurso.add(new Curso("Android"));
        listCurso.add(new Curso("Kotlin"));
        listCurso.add(new Curso("PHP"));
        listCurso.add(new Curso("HTML"));
        listCurso.add(new Curso("Java Script"));
        listCurso.add(new Curso("Python"));
        listCurso.add(new Curso("IOS"));


        return listCurso;

    }

    public ArrayList<String> dadosParaSpinner(){

        ArrayList<String> cursos = new ArrayList<>();

        for (int i = 0; i < getListaCurso().size(); i++) {

            Curso curso = (Curso) getListaCurso().get(i);
            cursos.add(curso.getNomeDoCursoDesejado());

        }


        return cursos;
    }
}
