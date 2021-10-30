package ru.geekbrains.homework7;

public interface Graph {

    // добавить вершину
    void addVertex(String label);

//    // добавить ребро (связь между вершинами)
//    boolean addEdge(String startLabel, String secondLabel);

    boolean addEdge(String startLabel,int edge, String secondLabel );

    boolean addEdge(String startLabel, int edge, String secondLabel, int thirdEdge, String thirdLabel);

    boolean addEdge(String startLabel, int edge, String secondLabel, int thirdEdge, String thirdLabel, int fourthEdge, String fourthLabel);

//    boolean addEdge(String startLabel, String secondLabel, String... others);

    // размер графа
    int getSize();

    // вывод графа
    void display();

    // обход графа в ширину
    public void bfs(String startLabel) ;

}
