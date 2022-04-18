public class JvmComprehension {
    // Класс JvmComprehension отдаётся для загрузки в систему загрузчиков классов (ClassLoader'ов);
    // Далее информация о классе JvmComprehension (имя, методы, поля и т.д.) передаётся в область памяти Metaspace;

    public static void main(String[] args) {
        // В момент вызова метода main создается фрейм(кадр) в стеке Stack Memory;

        int i = 1;                      // 1 - В стеке во фрейме "main" создаётся переменная "i" примитивного типа;
        // "int" и ей присваивается значение "1";

        Object o = new Object();        // 2 - В Куче (heap) создаётся объект "Object", а в стеке во фрейме "main";
        // создаётся переменная "o", которой присваивается ссылка на этот объект;

        Integer ii = 2;                 // 3 - В Куче (heap) создаётся объект "Integer" со значением "2", а в стеке;
        // во фрейме "main" создаётся переменная "ii", которой присваивается ссылка на этот объект;

        printAll(o, i, ii);             // 4 - В стеке создаётся фрейм "printAll", в который передаются переменные;
        // Object o, int i, Integer ii;

        System.out.println("finished"); // 7 - В стек во фрейм "println" передаётся ссылка на созданный в Куче (heap);
        // объект типа "String", которому присвоено значение "finished";

        // Во время выполнения программы отрабатывает сборщик мусора Garbage Collector;
    }

    private static void printAll(Object o, int i, Integer ii) {
        Integer uselessVar = 700;                   // 5 - В Куче (heap) создаётся объект "Integer" со значением "700",;
        // а в стеке во фрейме "printAll" создаётся переменная "uselessVar", которой присваивается ссылка на этот;
        // объект;

        System.out.println(o.toString() + i + ii);  // 6 - В стеке создаётся фрейм "println", в него передаются ссылки;
        // - "o" на находящийся в Куче (heap) объект "Object", - "i" на переменную "int" в стеке во фрейме "main",;
        // - "ii" на объект "Integer" в Куче (heap). В стеке создаётся фрейм "toString";
    }
}