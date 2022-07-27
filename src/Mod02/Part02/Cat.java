package Mod02.Part02;

import java.io.Serializable;

public class Cat {
    private Color color;
    private CatAttribute catAttribute;

    static class A{};
  public static class StaticTestClassCat{};

   private class CatAttribute implements Serializable {
        private String name;
        private  int age;

        public CatAttribute(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }

    public Cat(Color color) {
       this(color,"",0);
    }

    public Cat(Color color,String name, int age) {
        catAttribute = new CatAttribute(name,age);
        this.color = color;
    }
    private  void foo(int a, int b){
        class Calculate {
            public  int plus(int a, int b) {
                return a+b;
            }
            public  int subtract(int a, int b) {
                return a-b;
            }
        }

       Calculate calculate = new Calculate();
        System.out.println(calculate.plus(a, b));
        System.out.println(calculate.subtract(a, b));


    }

    @Override
    public String toString() {
        return String.format("У кота %s цвет %s(%s) и %s лет",catAttribute.getName(),color.getRussianColor(),
                color.getEnglishColor(), catAttribute.getAge());
    }
}
