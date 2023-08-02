package trello.example.trello.Service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import trello.example.trello.Models.Board;
import trello.example.trello.Models.Cards;
import trello.example.trello.Repository.CardsRepository;

import java.util.*;

@Service
public class CardsService {

    @Autowired
    CardsRepository cardsRepository;

    // Example data store to hold boards and cards.
    private static Map<Long, List<Cards>> boardToCardsMap = new HashMap<>();

    public Cards addCardToBoard(Long boardId, Cards newCard) {

        // Your implementation for addCardToBoard
        newCard.setSection(""); // Set the section (if required)

        // Save the card to the database using the repository
        Cards savedCard = cardsRepository.save(newCard);

        // Return the saved card
        return savedCard;
    }


    // Helper method to generate a unique card ID (you can implement your own logic)
    private static Long generateUniqueCardId() {
        // Implement your logic to generate a unique ID for the card
        // For example, you can use a counter or a random generator.
        // For simplicity, we'll return a random long value here.
        return new Random().nextLong();
    }

    // get all the cards
    public List<Cards> getCards(){
        return cardsRepository.findAll();
    }
}
