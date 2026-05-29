package tretak.maps;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class BookTask {
    static class Book{
        private int bookId;
        private String title;
        private String author;
        private List<Chapter> chapters = new ArrayList<>();

        public Book(int bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        public int getTotalPages() {
            // TODO: 26.03.2025 Dodelat, bude se hodit
            //return chapters.stream()
            //        .filter(chapter -> chapter.bookId == this.bookId)
            //        .mapToInt(chapter -> chapter.pages)
            //        .sum();
            int pages = this.chapters.stream()
                    .mapToInt(chapter -> chapter.pages)
                    .sum();
            return pages;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "bookId=" + bookId +
                    ", title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    ", chapters=" + chapters +
                    '}';
        }

        public int getBookId() {
            return bookId;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        public List<Chapter> getChapters() {
            return chapters;
        }
    }

    static class Chapter {
        // TODO: 26.03.2025 Dodelat vse potrebne
        private int chapterId;
        private int bookId;
        private String title;
        private int pages;

        public Chapter(int chapterId, int bookId, String title, int pages) {
            this.chapterId = chapterId;
            this.bookId = bookId;
            this.title = title;
            this.pages = pages;
        }

        public int getChapterId() {
            return chapterId;
        }

        public int getBookId() {
            return bookId;
        }

        public String getTitle() {
            return title;
        }

        public int getPages() {
            return pages;
        }

        @Override
        public String toString() {
            return "Chapter{" +
                    "chapterId=" + chapterId +
                    ", bookId=" + bookId +
                    ", title='" + title + '\'' +
                    ", pages=" + pages +
                    '}';
        }
    }


    static double authorPages(String name, List<Book> books) {
        return books.stream()
                .filter(book -> book.author.equals(name))
                .mapToDouble(Book::getTotalPages)
                .sum();

    }


    public static void main(String[] args) throws IOException {
        List<Book> books = Files.lines(Paths.get("inputs\\books.csv"))
                .skip(1)
                .map(line -> line.split(","))
                .map(parts -> new Book(
                        Integer.parseInt(parts[0]),
                        parts[1],
                        parts[2]
                ))
                .toList();




        List<Chapter> chapters = Files.lines(Paths.get("inputs\\chapters.csv"))
                .skip(1)
                .map(line -> line.split(","))
                .map(parts -> new Chapter(
                        Integer.parseInt(parts[0]),
                        Integer.parseInt(parts[1]),
                        parts[2],
                        Integer.parseInt(parts[3])
                ))
                .toList();
        //System.out.println(books);
        //System.out.println(chapters);


        for (Book book : books) {
            book.chapters = chapters.stream()
                    .filter(chapter -> chapter.bookId == book.bookId)
                    .toList();
            //System.out.println("----------dd------------");
            //System.out.println(book.chapters);
        }


        Map<String, Long> authorAndBooks = books.stream()
                .collect(Collectors.groupingBy(Book::getAuthor, Collectors.counting()));
        System.out.println(authorAndBooks);




        //for (Book book : books) {
        //    System.out.println(book.title);
        //    System.out.println(book.getTotalPages());
        //}

        Map<String, Double> topBooksByPages = books.stream()
                .collect(Collectors.groupingBy(Book::getTitle, Collectors.summingDouble(Book::getTotalPages)))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Double>comparingByValue().reversed())
                .limit(5)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println("----------------------------");
        System.out.println(topBooksByPages);


        System.out.println("---------------");
        System.out.println(authorPages("Matthew Hernandez", books));







    }
}
