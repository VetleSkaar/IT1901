# What is core?
Core contains files related to the functionality of the casino application.

Core contains:

Card: Contains logic for handling a standard 52-card type card. Uses help classes Suit and Value

Suit: Helping class for managing the suit of a card. 

Value: Helping class for managing the value of a card.

CardDeck: A list of Card class elememts. contains methods for shuffling and drawing cards.

UserInfo: Handles a users username, password and balance.

Player: The contestants in Blackjack game. Delegates name and account balance to UserInfo. Handles player in game sum, and in game cards. 

Action: contains name of action and wether it is available.

Blackjack: main logic for game blackjack.

BlackjackDefaults: Class for storing default values for blackjack game. contains cards in a standard 52-deck and actions in a blackjack game. 



