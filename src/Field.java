public class Field {
     int M;
     int N;
     byte [][] field;

    public Field (int y, int x) {
        this.M = y;
        this.N = x;
        field = new byte [M][N];
        fieldGen(field);
    }
    public Field (int y, int x, byte[][] field){
        this.M = y;
        this.N = x;
        this.field = new byte[M][N];
        this.field = field;
    }


    public void show() {
        for (int i = 0; i < M; i++) {
            for (int z = 0; z < N; z++) {
                System.out.print(field[i][z] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void fieldGen (byte [][] field) {
        for (int i = 0; i < M; i++){
            for (int z = 0; z < N; z++){
                field[i][z] = (byte) Math.round(Math.random());
            }
        }

    }
    public void fieldReview () {
        byte value;
        byte [][] neighbField = new byte[M][N];       // Создаем матрицу для записи результатов
        for (int i = 0; i < M; i++){                // Делаем перебор элементов поля
            for (int z = 0; z < N; z++){
                value = (byte) neighboursCount(field, i,z);       // Считаем колличество живых соседей
                if ((field[i][z] == 0) && value == 3) neighbField[i][z] = 1;  //Если клетка мертвая и рядом 3 живых - она оживает
                else if ((field[i][z] == 1) && ((value < 2 ) || (value > 3))) neighbField[i][z] = 0;  //Если клетка живая и рядом меньше 2х или больше 3х жвых - она умирает
                else neighbField[i][z] = field[i][z];

                value = 0;                                                                            //Обнуляем счетчик живых соседей
            }

        }
        field = neighbField;            // Записываем обновленную матрицу
    }
    private static int neighboursCount(byte[][] field, int a, int b) {
        int count = 0;
        for (int x = a - 1; x <= a + 1; x++){
            for (int y = b - 1; y <= b + 1; y++) {
                if (!(y < 0 || y > field[0].length - 1 ||
                        x < 0 || x > field.length - 1 ||
                        (y == b && x == a))){
                    count += field[x][y];
                }
            }
        }

        return count;
    }


}
