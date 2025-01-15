package com.example.readingdiary
import java.io.Serializable

class Book(
    var bookTitle: String,
    var bookAuthor: String,
    var bookDescription: String
) : Serializable

object BookData {
    val booksReadList = arrayListOf(
        Book("To Kill a Mockingbird", "Harper Lee", "A novel about racism and injustice."),
        Book("1984", "George Orwell", "A dystopian story of a totalitarian society."),
        Book("Pride and Prejudice", "Jane Austen", "A romantic novel of manners."),
    )

    val booksOnWishList = arrayListOf(
        Book(
            "The Seven Husbands of Evelyn Hugo",
            "Taylor Jenkins Reid",
            "Aging and reclusive Hollywood icon Evelyn Hugo is finally ready to tell the truth about her glamorous and scandalous life. When she chooses an unknown reporter, Monique Grant, to write her biography, secrets of fame, love, and betrayal come to light in a mesmerizing tale of ambition and resilience."
        ),
        Book(
            "Murder on the Orient Express",
            "Agatha Christie",
            "Detective Hercule Poirot is aboard the luxurious Orient Express when a passenger is found murdered in his cabin. With the train stranded by snow, Poirot races against time to solve the mystery, uncovering a web of secrets and motives among the passengers in one of Christie's most iconic whodunits."
        ),
        Book(
            "Fourth Wing",
            "Rebecca Yarros",
            "In the elite dragon-riding academy of Basgiath War College, Violet Sorrengail must survive ruthless rivals and dangerous trials to bond with a dragon and claim her place among the dragonriders. But with deadly conspiracies at play, survival is only the beginning in this thrilling fantasy adventure."
        ),
        Book(
            "Anxious People",
            "Fredrik Backman",
            "A failed bank robber takes a group of strangers hostage during an apartment viewing. As tensions rise, secrets are revealed, and the hostages discover they are connected in unexpected and humorous ways. Backman's novel is a heartwarming and quirky exploration of human relationships."
        ),
        Book(
            "The Girl with the Dragon Tattoo",
            "Stieg Larsson",
            "Journalist Mikael Blomkvist teams up with enigmatic hacker Lisbeth Salander to investigate the decades-old disappearance of a wealthy heiress. Their quest uncovers a dark family history and puts them in the crosshairs of a killer in this gripping Scandinavian crime thriller."
        ),
    )
}
