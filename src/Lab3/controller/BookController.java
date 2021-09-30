package Lab3.controller;

import Lab3.controller.exceptions.FutureYearException;
import Lab3.controller.exceptions.NegativeNumberException;
import Lab3.model.BookConverter;
import Lab3.model.BookModel;
import Lab3.utility.InputUtility;
import Lab3.view.BookView;

public class BookController {

    private BookModel model;
    private BookView view;

    public BookController() {
        model = new BookModel();
        view = new BookView();
        InputUtility.setView(view);
    }

    public void addBook() {
        int year = InputUtility.inputYearValueWithScanner();
        try {
            Validator.validateYearValue(year);
        } catch (NegativeNumberException e) {
            view.printlnMessage(view.WRONG_NEGATIVE_DATA);
            return;
        } catch (FutureYearException e) {
            view.printlnMessage(view.TOO_BIG_YEAR_DATA);
            return;
        }
        double price = InputUtility.inputDoubleValueWithScanner();
        try {
            Validator.validateDoubleValue(price);
        } catch (NegativeNumberException e) {
            view.printlnMessage(view.WRONG_NEGATIVE_DATA);
            return;
        }
        model.addBook(InputUtility.inputTitleValueWithScanner(), InputUtility.inputAuthorValueWithScanner(), InputUtility.inputPublishingHouseValueWithScanner(), year, price);
    }

    public void findBooksFromSetAuthor() {
        view.printArray(BookConverter.getArrayInString(model.findBooksFromSetAuthor(InputUtility.inputAuthorValueWithScanner())));
    }

    public void findBooksFromSetPublishingHouse() {
        view.printArray(BookConverter.getArrayInString(model.findBooksFromSetPublishingHouse(InputUtility.inputPublishingHouseValueWithScanner())));
    }

    public void findBooksPublishedLaterThanSetYear() {
        view.printArray(BookConverter.getArrayInString(model.findBooksPublishedLaterThanSetYear(InputUtility.inputYearValueWithScanner())));
    }

    public void runMenu() {
        view.printlnMessage(view.GREETINGS);
        int switchVar;
        while (true) {
            view.printlnMessage(view.MENU_POSSIBILITIES);
            switchVar = InputUtility.inputSwitchValueWithScanner();

            switch (switchVar) {

                case 1:
                    view.printArray(BookConverter.getArrayInString(model.getStorage()));
                    break;
                case 2:
                    addBook();
                    break;
                case 3:
                    findBooksFromSetAuthor();
                    break;
                case 4:
                    findBooksFromSetPublishingHouse();
                    break;
                case 5:
                    findBooksPublishedLaterThanSetYear();
                    break;
                case 6:
                    System.exit(1000);
                    break;
                default:
                    view.printlnMessage(BookView.WRONG_INPUT_INT_DATA);
                    break;
            }
        }
    }

}