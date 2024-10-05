import java.util.ArrayList;
import java.util.List;

public class MainFunctional {

    public static void main(String[] args) {
        List<Animal> animais = new ArrayList<Animal>();
        animais.add(new Animal("peixe", false, true));
        animais.add(new Animal("canguru", true, false));
        animais.add(new Animal("coelho", true, false));
        animais.add(new Animal("tartaruga", false, true));

        System.out.println("Animais que nadam:");
        imprimir(animais, new Verificador() {
            @Override
            public Boolean verificar(Animal animal) {
                return animal.getSwim();
            }
        });

        System.out.println("-------------");

        System.out.println("Animais que pulam:");
        imprimir(animais,
                (animal)/*Declara variável*/ -> animal.getJump()/*Código executável do método*/
        );
        imprimir(animais, Animal::getJump);

        System.out.println("-------------");
        System.out.println("Animais que voam");
        imprimir(animais, new VerificaVoo());
    }

    public static void imprimir(List<Animal> animais, Verificador verificar) {
        for (Animal animal : animais) {
            if (verificar.verificar(animal)) {
                System.out.println("Animal: "+animal.getType()+" passou na verificação");
            }
        }
    }

}
