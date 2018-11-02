package com.eastmoney.readinglist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @author Administrator
 * created: 2018-10-31 15:50
 */
@Controller
@RequestMapping("/readingList")
//@ConfigurationProperties(prefix = "amazon") //仅用于3.2.2节
public class ReadingListController {
    private ReadingListRepository readingListRepository;
    //    private String associateId; //仅用于3.2.2节
    private AmazonProperties amazonProperties;
    
    @Autowired
    public ReadingListController(ReadingListRepository readingListRepository, AmazonProperties amazonProperties) {
        this.readingListRepository = readingListRepository;
        this.amazonProperties = amazonProperties;
    }

//    public void setAssociateId(String associateId) { //associateId的setter方法，仅用于3.2.2节
//        this.associateId = associateId;
//    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String readerBooks(Model model) {
//        final List<Book> books = new ArrayList<>();
        final List<Book> books = readingListRepository.findAll();
        model.addAttribute("books", books);
        return "readingList";
    }
    
    @RequestMapping(value = "/{reader}", method = RequestMethod.GET)
    public String readerBooks(@PathVariable("reader") String reader, Model model) {
        List<Book> readingList = readingListRepository.findByReader(reader);
        if (readingList != null) {
            model.addAttribute("books", readingList);
            model.addAttribute("reader", reader);
            model.addAttribute("amazonID", amazonProperties.getAssociateId()); //将associateId放入模型
        }
        return "readingList";
    }
    
    @RequestMapping(value = "/{reader}", method = RequestMethod.POST)
    public String addToReadingList(@PathVariable("reader") String reader, Book book) {
        book.setReader(reader);
        readingListRepository.save(book);
        return "redirect:/readingList/{reader}";
    }
}
