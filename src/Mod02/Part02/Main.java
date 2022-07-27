package Mod02.Part02;

public class Main {
    public static void main(String[] args) {
        Cat cat = new Cat(Color.BLACK);
        Cat cat2 = new Cat(Color.WHITE);
//        System.out.println(cat);
//        System.out.println(cat2);
//        testAnnonClasses();
        testInnerClasses();
    }


    private static void testInnerClasses() {
        Cat cat = new Cat(Color.RED,"Риччард",8);
//      Cat.CatAttribute catAttribute = cat.new CatAttribute("Риччард",8);
//        System.out.println(catAttribute);
        System.out.println(cat);

        Cat.StaticTestClassCat classCat = new Cat.StaticTestClassCat();
    }

    private static void testAnnonClasses(){
//        SomeOneFileToImplement foo = new Foo();
//        SomeOneFileToImplement bar = new Bar();
        SomeOneFileToImplement foo = new SomeOneFileToImplement() {
            @Override
            public void action() {
                System.out.println("Привет Мир");
            }
        };

    SomeOneFileToImplement bar = new SomeOneFileToImplement() {
        @Override
        public void action() {
            System.out.println("Привет, Мир");
        }
    };
        foo.action();
        bar.action();

        test(foo);
    }

    private static void test(SomeOneFileToImplement o){
        System.out.println("Действие");
        System.out.println("Действие");
        System.out.println("Действие");
        o.action();
        System.out.println("Действие");
        System.out.println("Действие");
        System.out.println("Действие");
        System.out.println("======");
    }
}
