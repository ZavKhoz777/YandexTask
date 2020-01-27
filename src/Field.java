public class Field {
     int M;
     int N;
     int [][] field;

    public Field (int y, int x) {
        this.M = y;
        this.N = x;
        field = new int [M][N];
        fieldGen(field);
    }

    public void show() {
        for (int i = 0; i < M; i++) {
            for (int z = 0; z < N; z++) {
                System.out.print(field[i][z] + " ");
            }
            System.out.println();
        }
    }

    private void fieldGen (int [][] field) {
        for (int i = 0; i < M; i++){
            for (int z = 0; z < N; z++){
                field[i][z] = (int) Math.round(Math.random());
            }
        }

    }
    public void fieldReview () {
        int value;
        int [][] neighbField = new int[M][N];       // Создаем матрицу для записи результатов
        for (int i = 0; i < M; i++){                // Делаем перебор элементов поля
            for (int z = 0; z < N; z++){
                value = neighboursCount(i,z);       // Считаем колличество живых соседей
                if ((field[i][z] == 0) && value == 3) neighbField[i][z] = 1;  //Если клетка мертвая и рядом 3 живых - она оживает
                else if ((field[i][z] == 1) && ((value < 2 ) || (value > 3))) neighbField[i][z] = 0;  //Если клетка живая и рядом меньше 2х или больше 3х жвых - она умирает
                else neighbField[i][z] = field[i][z];
                System.out.print(i + " " + z + " " + "count = " + value + " ");//delete
                value = 0;                                                                            //Обнуляем счетчик живых соседей
            }
            System.out.println();//delete
        }
        field = neighbField;            // Записываем обновленную матрицу
    }
    private int neighboursCount (int a, int b) {
        int count = 0;
        for (int x = a - 1; x < a + 2; x++){
            for (int y = b - 1; y < b + 2; y++) {
                if (!((y < 0) || (x < 0) || (y > N - 1) || (x > M - 1) || (y == b) || (x == a))){
                    count += field[a][b];
                }
            }
        }
        return count;
    }


}
