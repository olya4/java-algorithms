package ru.geekbrains.homework7;

public class Main {
    public static void main(String[] args) {
        testDfs();

    }

    private static void testDfs() {
        Graph graph = new GraphImpl(10);
        graph.addVertex("Москва");
        graph.addVertex("Тула");
        graph.addVertex("Рязань");
        graph.addVertex("Калуга");
        graph.addVertex("Липецк");
        graph.addVertex("Тамбов");
        graph.addVertex("Орел");
        graph.addVertex("Саратов");
        graph.addVertex("Курск");
        graph.addVertex("Воронеж");

        graph.addEdge("Москва", 173, "Тула",183, "Рязань",162,"Калуга");
        graph.addEdge("Тула", 219, "Липецк",108, "Воронеж");
        graph.addEdge("Рязань", 240, "Тамбов",339, "Саратов",472,"Воронеж");
        graph.addEdge("Калуга", 172, "Орел",138, "Курск",207,"Воронеж");

        graph.bfs("Москва");
//        graph.display();

    }
}
