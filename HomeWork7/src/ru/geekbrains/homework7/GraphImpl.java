package ru.geekbrains.homework7;

import java.util.*;

public class GraphImpl implements Graph {

    // список вершин
    private final List<Vertex> vertexList;
    // двумерный массив для матрицы смежности
    private final int[][] adjMatrix;

    // maxVertexCount - максимальное количество вершин
    public GraphImpl(int maxVertexCount) {
        this.vertexList = new ArrayList<>(maxVertexCount);
        this.adjMatrix = new int[maxVertexCount][maxVertexCount];
    }

    // добавить вершину
    @Override
    public void addVertex(String label) {
        // в список вершин добавить новую вершину (название вершины)
        vertexList.add(new Vertex(label));
    }

    // добавить ребро (связь между вершинами)
    @Override
    public boolean addEdge(String startLabel, int edge, String secondLabel) {
        // индекс первой вершины
        int startIndex = indexOf(startLabel);
        // индекс второй вершины
        int endIndex = indexOf(secondLabel);

        // если индекс вершин не найден
        if (startIndex == -1 || endIndex == -1) {
            return false;
        }

        // если индекс вершин найден
        adjMatrix[startIndex][endIndex] = edge;
        return true;
    }

    // преобразует вершину в индекс
    private int indexOf(String label) {
        // перебор всего списка вершин
        for (int i = 0; i < vertexList.size(); i++) {
            // из списка взять вершину с ее индексом и сравнить по названию с искомой
            if (vertexList.get(i).getLabel().equals(label)) {
                // если найдена, вернуть ее индекс
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean addEdge(String startLabel, int edge, String secondLabel, int thirdEdge, String thirdLabel, int fourthEdge, String fourthLabel) {
        // результат добавления ребра между двух заданных вершин
        boolean result = addEdge(startLabel, edge, secondLabel);
        // &= - логическое умножение
        // result = логическому умножению полученных результатов из метода по добавлению между двух заданных вершин
        result &= addEdge(startLabel, thirdEdge, thirdLabel);
        result &= addEdge(startLabel, fourthEdge, fourthLabel);

        return result;
    }

    @Override
    public boolean addEdge(String startLabel, int edge, String secondLabel, int thirdEdge, String thirdLabel) {
        // результат добавления ребра между двух заданных вершин
        boolean result = addEdge(startLabel, edge, secondLabel);
        // &= - логическое умножение
        // result = логическому умножению полученных результатов из метода по добавлению между двух заданных вершин
        result &= addEdge(startLabel, thirdEdge, thirdLabel);

        return result;
    }

    // размер графа
    @Override
    public int getSize() {
        return vertexList.size();
    }

    @Override
    public void display() {
        // пройтись по списку
        for (int i = 0; i < getSize(); i++) {
            // вывести одну вершину
            System.out.print(vertexList.get(i));
            // пройтись по списку
            for (int j = 0; j < getSize(); j++) {
                // если в матрице смежности есть связь между первой и второй вершиной
                if (adjMatrix[i][j] != 0) {
                    // вывести вторую вершину
                    System.out.print(" -> " + adjMatrix[i][j] + " -> " + vertexList.get(j));
                }
            }
            System.out.println();
        }
    }

    // обход графа в ширину
    @Override
    public void bfs(String startLabel) {
        int startIndex = indexOf(startLabel);
        if (startIndex == -1) {
            throw new IllegalArgumentException("Неверная вершина: " + startLabel);
        }

        // очередь для вершин
        Queue<Vertex> queue = new LinkedList<>();
        // vertex = вершина, находящаяся в данный момент в работе
        Vertex vertex = vertexList.get(startIndex);

        // посетить вершину
        visitedVertex(queue, vertex);
        // если очередь не пустая
        while (!queue.isEmpty()) {
            // найти индекс самого верхнего элемента очереди
            vertex = getNearUnvisitedVertex(queue.peek());
            // если такая вершина есть
            if (vertex != null) {
                // посетить вершину
                visitedVertex(queue, vertex);
            } else {
                // удалить посещенную вершину из очереди
                queue.remove();
            }
        }
        System.out.println();
    }

    // получить ближайшую не посещенную вершину
    private Vertex getNearUnvisitedVertex(Vertex vertex) {
        // найти индекс самого верхнего элемента стека
        int currentIndex = vertexList.indexOf(vertex);
        int sum = 0;

        for (int i = 0; i < getSize(); i++) {
            // вывести одну вершину
            System.out.print(vertex + " -> ");
            System.out.print(vertexList.get(i));
            // пройтись по списку
            for (int j = 0; j < getSize(); j++) {
                // если в матрице смежности есть связь между первой и второй вершиной
                if (adjMatrix[i][j] != 0 && !vertexList.get(i).isVisited()) {
                    sum += adjMatrix[i][j];
                    // вывести вторую вершину
                    System.out.print(" -> " + adjMatrix[i][j] + " -> " + vertexList.get(j));
                    System.out.print(" " + sum);
                }
            }
            System.out.println();
        }
        return null;
    }

    // посетить вершину очереди
    private void visitedVertex(Queue<Vertex> queue, Vertex vertex) {
        // вывести посещаемую вершину
        System.out.print(vertex.getLabel() + " ");
        // добавить посещаемую вершину в очередь
        queue.add(vertex);
        // присвоить вершине статус - посещена
        vertex.setVisited(true);
    }
}
