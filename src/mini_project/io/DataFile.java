package mini_project.io;

import mini_project.model.Movie;
import mini_project.service.MovieService;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;


public class DataFile {
    private final static String PATH = "src/mini_project/data/";
    private final static String FILE_NAME = "data.txt";

    public static void load(MovieService service) {
        File data = new File(PATH + FILE_NAME);
        if (!data.exists()) return;

        try ( BufferedReader br = new BufferedReader(new FileReader(data)) ) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] join = line.split(" \\| ");
                if (join.length < 5) continue;

                String title = join[0];
                String type  = join[1];
                String genre = join[2];
                int price    = Integer.parseInt(join[3]);
                String reservedStr = join[4];

                // 영화 등록
                String id = service.addMovie(title, type, genre, price);

                // 예매 복원
                if (!reservedStr.equals("null")) {
                    String[] codes = reservedStr.split(",");
                    for (String item : codes) {
                        service.reserveSeat(id, item);
                    }
                }
            }
        } catch (IOException e) {
            System.err.println("로드 오류: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("로드 기타 오류: " + e.getMessage());
        }
    }

    public static void save(MovieService service) {
        File dir = new File(PATH);
        if (!dir.exists()) dir.mkdirs();

        try ( PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(PATH + FILE_NAME))) ) {
            for (Map.Entry<String, Movie> entry : service.getMovieCtrl().getMovieMap().entrySet()) {
                String id = entry.getKey();
                Movie movie = entry.getValue();

                Set<String> reserved = service.getSeat(id).getReservedSeat();
                String reservedStr = reserved.isEmpty() ? "null" : String.join(",", reserved);

                pw.printf("%s | %s | %s | %d | %s%n",
                        movie.getTitle(),
                        movie.getType(),
                        movie.getGenre(),
                        movie.getPrice(),
                        reservedStr
                );
            }

        } catch (IOException e) {
            System.err.println("저장 오류: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("저장 기타 오류: " + e.getMessage());
        }
    }
}
