package pl.sda.bestwatch;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(BestwatchController.API_BESTWATCH_PATH)
public class BestwatchController {

    public static final String API_BESTWATCH_PATH = "/api/bestwatch";

    private Suggestion suggestion;
    private ArrayList<Suggestion> suggestions;

    public BestwatchController(){
        suggestions = new ArrayList<Suggestion>();
       // suggestion = new Suggestion(1,"AAA","link_1","autor1");
     ///   suggestions.add(suggestion);
        suggestions.add(new Suggestion(1,"AAA","link_1","autor1"));
        suggestions.add(new Suggestion(2,"BBB","link_2","autor2"));
        suggestions.add(new Suggestion(3,"CCC","link_3","autor3"));


    }

    @GetMapping
    public Iterable<Suggestion> get() {
     /*   suggestions = new ArrayList<>();
        if (suggestion != null)
            suggestions.add(suggestion);
    */
        return suggestions;
    }



    @PostMapping
    public void add(@RequestBody Suggestion suggestion) {

     //   this.suggestion = suggestion;
        suggestions.add(suggestion);
    }
    @GetMapping("/{id}")
    public Suggestion getById(@PathVariable int id){
        Optional<Suggestion> suggestionByID = suggestions.stream().filter(element ->element.getId()==id).findFirst();
        return suggestionByID.get();
    }

    @PatchMapping("/{id}")
    public void updateSuggestion(@PathVariable int id, @RequestBody Suggestion suggestionPatch){
        Optional<Suggestion> suggestionToUpdate = suggestions.stream().filter(element ->element.getId()==id).findFirst();
        suggestionToUpdate.ifPresent(suggestion->{
            String moviePatch = suggestionPatch.getMovie();
            String linkPatch = suggestionPatch.getLink();
            String authorPatch = suggestionPatch.getAuthor();
            if (!moviePatch.isEmpty()){
               suggestion.setMovie(moviePatch);
            }
            if (!linkPatch.isEmpty()){
                suggestion.setLink(linkPatch);
            }
            if (!authorPatch.isEmpty()){
                suggestion.setAuthor(authorPatch);
            }
            suggestions.set(id,suggestion);
        }
        );
    }
    @DeleteMapping("/{id}")
    public void deleteSuggestion(@PathVariable int id){
        suggestions.removeIf(element ->element.getId()==id);
    }

}
