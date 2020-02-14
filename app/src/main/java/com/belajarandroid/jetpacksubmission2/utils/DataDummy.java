package com.belajarandroid.jetpacksubmission2.utils;

import com.belajarandroid.jetpacksubmission2.data.FilmEntity;
import com.belajarandroid.jetpacksubmission2.data.source.remote.response.MovieResponse;
import com.belajarandroid.jetpacksubmission2.data.source.remote.response.ShowResponse;

import java.util.ArrayList;

public class DataDummy {

    public static ArrayList<FilmEntity> generateDummyMovie() {

        ArrayList<FilmEntity> movie = new ArrayList<>();

        movie.add(new FilmEntity("419704",
                "/xBHvZcjRiWyobQ9kxBhO6B2dtRI.jpg",
                "/5BwqwxMEjeFtdknRV792Svo0K1v.jpg",
                "Ad Astra",
                "Sep 17, 2019",
                "6.0",
                "Adventure, Drama, Mystery, Science Fiction, Thriller",
                "en",
                "The near future, a time when both hope and hardships drive humanity to look to the stars and beyond. While a mysterious phenomenon menaces to destroy life on planet Earth, astronaut Roy McBride undertakes a mission across the immensity of space and its many perils to uncover the truth about a lost expedition that decades before boldly faced emptiness and silence in search of the unknown.",
                "513.129"));

        movie.add(new FilmEntity("m02",
                "/AuGiPiGMYMkSosOJ3BQjDEAiwtO.jpg",
                "/ds9GKAMhxv5AbprmZ2xCpK8FiEG.jpg",
                "1917",
                "Dec 10, 2019",
                "8.1",
                "War, Drama, History, Action",
                "en",
                "At the height of the First World War, two young British soldiers, Schofield and Blake are given a seemingly impossible mission. In a race against time, they must cross enemy territory and deliver a message that will stop a deadly attack on hundreds of soldiers—Blake's own brother among them.",
                "244.49"));

        movie.add(new FilmEntity("m03",
                "/y95lQLnuNKdPAzw9F9Ab8kJ80c3.jpg",
                "/iUspPEAjhUUrLYKntTnKupt3eqV.jpg",
                "Bad Boys For Life",
                "Jan 15, 2020",
                "6.6",
                "Thriller, Action, Crime",
                "en",
                "Marcus and Mike are forced to confront new threats, career changes, and midlife crises as they join the newly created elite team AMMO of the Miami police department to take down the ruthless Armando Armas, the vicious leader of a Miami drug cartel.",
                "205.327"));

        movie.add(new FilmEntity("m04",
                "/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg",
                "/n6bUvigpRFqSwmPp1m2YADdbRBc.jpg",
                "Joker",
                "Oct 02, 2019",
                "8.3",
                "Crime, Thriller, Drama",
                "en",
                "During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.",
                "171.92"));

        movie.add(new FilmEntity("m05",
                "/p69QzIBbN06aTYqRRiCOY1emNBh.jpg",
                "/sZAXOoOMyCbBskmqR0f4LShxXtw.jpg",
                "Doctor Sleep",
                "Oct 30, 2019",
                "7.1",
                "Horror, Drama, Fantasy",
                "en",
                "Still irrevocably scarred by the trauma he endured as a child at the Overlook, Dan Torrance has fought to find some semblance of peace. But that peace is shattered when he encounters Abra, a courageous teenager with her own powerful extrasensory gift, known as the 'shine'.\\\" Instinctively recognising that Dan shares her power, Abra has sought him out, desperate for his help against the merciless Rose the Hat and her followers.",
                "145.365"));

        movie.add(new FilmEntity("m06",
                "/yJdeWaVXa2se9agI6B4mQunVYkB.jpg",
                "/ekP6EVxL81lZ4ivcqPsoZ72rY0h.jpg",
                "Ip Man 4: The Finale",
                "Dec 20, 2019",
                "5.8",
                "Action, Drama, History",
                "en",
                "Following the death of his wife, Ip Man travels to San Francisco to ease tensions between the local kung fu masters and his star student, Bruce Lee, while searching for a better future for his son.",
                "156.889"));

        movie.add(new FilmEntity("m07",
                "/s5HQf2Gb3lIO2cRcFwNL9sn1o1o.jpg",
                "/1n00NlOGRFZVs8coBxyZLm5l4EC.jpg",
                "Transformer: The Last Knight",
                "Jun 16, 2017",
                "6.0",
                "Action, Science Fiction, Thriller, Adventure",
                "en",
                "Autobots and Decepticons are at war, with humans on the sidelines. Optimus Prime is gone. The key to saving our future lies buried in the secrets of the past, in the hidden history of Transformers on Earth.",
                "83.858"));

        movie.add(new FilmEntity("m08",
                "/vqzNJRH4YyquRiWxCCOH0aXggHI.jpg",
                "/riTANvQ8GKmQbgtC1ps3OfkU43A.jpg",
                "Terminator: Dark Fate",
                "Oct 23, 2019",
                "6.2",
                "Action, Science Fiction",
                "en",
                "Decades after Sarah Connor prevented Judgment Day, a lethal new Terminator is sent to eliminate the future leader of the resistance. In a fight to save mankind, battle-hardened Sarah Connor teams up with an unexpected ally and an enhanced super soldier to stop the deadliest Terminator yet.",
                "138.576"));

        movie.add(new FilmEntity("m09",
                "/db32LaOibwEliAmSL2jjDF6oDdj.jpg",
                "/jOzrELAzFxtMx2I4uDGHOotdfsS.jpg",
                "Star Wars: The Rise of Skywalker",
                "Dec 18, 2019",
                "6.5",
                "Action, Adventure, Science Fiction",
                "en",
                "The surviving Resistance faces the First Order once again as the journey of Rey, Finn and Poe Dameron continues. With the power and knowledge of generations behind them, the final battle begins.",
                "119.03"));

        movie.add(new FilmEntity("m10",
                "/7IiTTgloJzvGI1TAYymCfbfl3vT.jpg",
                "/TU9NIjwzjoKPwQHoHshkFcQUCG.jpg",
                "Parasite",
                "May 30, 2019",
                "8.6",
                "Comedy, Thriller, Drama",
                "en",
                "All unemployed, Ki-taek's family takes peculiar interest in the wealthy and glamorous Parks for their livelihood until they get entangled in an unexpected incident.",
                "106.013"));
        return movie;
    }

    public static ArrayList<FilmEntity> generateDummyShow() {
        ArrayList<FilmEntity> show = new ArrayList<>();

        show.add(new FilmEntity("s01",
                "/lHZ4xqGQlmyiFTOVtwnNpTcZgkd.jpg",
                "/q54k3tg5VjezBagGRtFamVqdY7L.jpg",
                "Insatiable",
                "Aug 10, 2018",
                "7.6",
                "Drama, Comedy",
                "en",
                "A bullied teenager turns to beauty pageants as a way to exact her revenge, with the help of a disgraced coach who soon realizes he's in over his head.",
                "754.632"));

        show.add(new FilmEntity("s02",
                "/jQNOzoiaIQWxJAx8OUighnvnhRA.jpg",
                "/gVVaukIifGJD78llZKgyT5FQbAe.jpg",
                "Thieves of the Wood",
                "Jan 02, 2020",
                "5.6",
                "Drama, Mystery",
                "en",
                "Charismatic highwayman Jan de Lichte leads the oppressed and downtrodden in a revolt against the corrupt aristocracy of 18th-century Belgium.",
                "468.515"));

        show.add(new FilmEntity("s03",
                "/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
                "/dKxkwAJfGuznW8Hu0mhaDJtna0n.jpg",
                "Arrow",
                "Oct 10, 2012",
                "5.9",
                "Crime, Drama, Mystery",
                "en",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "292.791"));

        show.add(new FilmEntity("s04",
                "/qcr9bBY6MVeLzriKCmJOv1562uY.jpg",
                "/f5uNbUC76oowt5mt5J9QlqrIYQ6.jpg",
                "The Simpsons",
                "Dec 17, 1989",
                "7.2",
                "Animation, Comedy",
                "en",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "164.056"));

        show.add(new FilmEntity("s05",
                "/nIlAKIrLKxOeoEnc0Urb65yNCp.jpg",
                "/mK286PAkhgLJqk5cO0BCmFLkNE7.jpg",
                "Star Trek: Picard",
                "Jan 23, 2020",
                "8.6",
                "Sci-Fi & Fantasy",
                "en",
                "Star Trek: Picard features Sir Patrick Stewart reprising his iconic role as Jean-Luc Picard, which he played for seven seasons on Star Trek: The Next Generation. Set twenty years after the events of Star Trek Nemesis, this series follow the now-retired Admiral Picard into the next chapter of his life.",
                "178.002"));

        show.add(new FilmEntity("s06",
                "/KoYWXbnYuS3b0GyQPkbuexlVK9.jpg",
                "/o9OKe3M06QMLOzTl3l6GStYtnE9.jpg",
                "Supernatural",
                "Sep 13, 2005",
                "7.5",
                "Drama, Mystery, Sci-Fi & Fantasy",
                "en",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way.",
                "160.463"));

        show.add(new FilmEntity("s07",
                "/qJdfO3ahgAMf2rcmhoqngjBBZW1.jpg",
                "/mzzHr6g1yvZ05Mc7hNj3tUdy2bM.jpg",
                "Rick and Morty",
                "Dec 02, 2013",
                "8.6",
                "Animation, Comedy, Sci-Fi & Fantasy",
                "en",
                "Rick is a mentally-unbalanced but scientifically-gifted old man who has recently reconnected with his family. He spends most of his time involving his young grandson Morty in dangerous, outlandish adventures throughout space and alternate universes. Compounded with Morty's already unstable family life, these events cause Morty much distress at home and school.",
                "154.306"));

        show.add(new FilmEntity("s08",
                "/cDDb7WA2i7cENhkEEjXEDrXGyNL.jpg",
                "/nfH8SZJVOxcBlFaqqtoqS5hHizG.jpg",
                "Doctor Who",
                "Mar 26, 2005",
                "7.0",
                "Drama, Sci-Fi & Fantasy",
                "en",
                "The Doctor is a Time Lord: a 900 year old alien with 2 hearts, part of a gifted civilization who mastered time travel. The Doctor saves planets for a living—more of a hobby actually, and the Doctor's very, very good at it.",
                "121.924"));

        show.add(new FilmEntity("s09",
                "/6t6r1VGQTTQecN4V0sZeqsmdU9g.jpg",
                "/kOvt2BOOwSAQCT8yo3pM3X2GXjh.jpg",
                "Law & Order: Special Victims Unit",
                "Sep 20, 1999",
                "6.5",
                "Crime, Drama",
                "en",
                "In the criminal justice system, sexually-based offenses are considered especially heinous. In New York City, the dedicated detectives who investigate these vicious felonies are members of an elite squad known as the Special Victims Unit. These are their stories.",
                "157.393"));

        show.add(new FilmEntity("s10",
                "/ff1zhqvwfS5HvRNcA5UFrH0PA2q.jpg",
                "/aq2yEMgRQBPfRkrO0Repo2qhUAT.jpg",
                "Vikings",
                "Mar 03, 2013",
                "7.5",
                "Drama",
                "en",
                "The adventures of Ragnar Lothbrok, the greatest hero of his age. The series tells the sagas of Ragnar's band of Viking brothers and his family, as he rises to become King of the Viking tribes. As well as being a fearless warrior, Ragnar embodies the Norse traditions of devotion to the gods. Legend has it that he was a direct descendant of Odin, the god of war and warriors.",
                "125.564"));

        return show;
    }

    public static ArrayList<MovieResponse> generateRemoteDummyMovie() {

        ArrayList<MovieResponse> movie = new ArrayList<>();

        movie.add(new MovieResponse("419704",
                "/xJUILftRf6TJxloOgrilOTJfeOn.jpg",
                "/5BwqwxMEjeFtdknRV792Svo0K1v.jpg",
                "Ad Astra",
                "Sep 17, 2019",
                "6.0",
                "Science Fiction, Drama, Thriller, Adventure, Mystery",
                "en",
                "The near future, a time when both hope and hardships drive humanity to look to the stars and beyond. While a mysterious phenomenon menaces to destroy life on planet Earth, astronaut Roy McBride undertakes a mission across the immensity of space and its many perils to uncover the truth about a lost expedition that decades before boldly faced emptiness and silence in search of the unknown.",
                "428.09"));

        movie.add(new MovieResponse("m02",
                "/AuGiPiGMYMkSosOJ3BQjDEAiwtO.jpg",
                "/ds9GKAMhxv5AbprmZ2xCpK8FiEG.jpg",
                "1917",
                "Dec 10, 2019",
                "8.1",
                "War, Drama, History, Action",
                "en",
                "At the height of the First World War, two young British soldiers, Schofield and Blake are given a seemingly impossible mission. In a race against time, they must cross enemy territory and deliver a message that will stop a deadly attack on hundreds of soldiers—Blake's own brother among them.",
                "244.49"));

        movie.add(new MovieResponse("m03",
                "/y95lQLnuNKdPAzw9F9Ab8kJ80c3.jpg",
                "/iUspPEAjhUUrLYKntTnKupt3eqV.jpg",
                "Bad Boys For Life",
                "Jan 15, 2020",
                "6.6",
                "Thriller, Action, Crime",
                "en",
                "Marcus and Mike are forced to confront new threats, career changes, and midlife crises as they join the newly created elite team AMMO of the Miami police department to take down the ruthless Armando Armas, the vicious leader of a Miami drug cartel.",
                "205.327"));

        movie.add(new MovieResponse("m04",
                "/udDclJoHjfjb8Ekgsd4FDteOkCU.jpg",
                "/n6bUvigpRFqSwmPp1m2YADdbRBc.jpg",
                "Joker",
                "Oct 02, 2019",
                "8.3",
                "Crime, Thriller, Drama",
                "en",
                "During the 1980s, a failed stand-up comedian is driven insane and turns to a life of crime and chaos in Gotham City while becoming an infamous psychopathic crime figure.",
                "171.92"));

        movie.add(new MovieResponse("m05",
                "/p69QzIBbN06aTYqRRiCOY1emNBh.jpg",
                "/sZAXOoOMyCbBskmqR0f4LShxXtw.jpg",
                "Doctor Sleep",
                "Oct 30, 2019",
                "7.1",
                "Horror, Drama, Fantasy",
                "en",
                "Still irrevocably scarred by the trauma he endured as a child at the Overlook, Dan Torrance has fought to find some semblance of peace. But that peace is shattered when he encounters Abra, a courageous teenager with her own powerful extrasensory gift, known as the 'shine'.\\\" Instinctively recognising that Dan shares her power, Abra has sought him out, desperate for his help against the merciless Rose the Hat and her followers.",
                "145.365"));

        movie.add(new MovieResponse("m06",
                "/yJdeWaVXa2se9agI6B4mQunVYkB.jpg",
                "/ekP6EVxL81lZ4ivcqPsoZ72rY0h.jpg",
                "Ip Man 4: The Finale",
                "Dec 20, 2019",
                "5.8",
                "Action, Drama, History",
                "en",
                "Following the death of his wife, Ip Man travels to San Francisco to ease tensions between the local kung fu masters and his star student, Bruce Lee, while searching for a better future for his son.",
                "156.889"));

        movie.add(new MovieResponse("m07",
                "/s5HQf2Gb3lIO2cRcFwNL9sn1o1o.jpg",
                "/1n00NlOGRFZVs8coBxyZLm5l4EC.jpg",
                "Transformer: The Last Knight",
                "Jun 16, 2017",
                "6.0",
                "Action, Science Fiction, Thriller, Adventure",
                "en",
                "Autobots and Decepticons are at war, with humans on the sidelines. Optimus Prime is gone. The key to saving our future lies buried in the secrets of the past, in the hidden history of Transformers on Earth.",
                "83.858"));

        movie.add(new MovieResponse("m08",
                "/vqzNJRH4YyquRiWxCCOH0aXggHI.jpg",
                "/riTANvQ8GKmQbgtC1ps3OfkU43A.jpg",
                "Terminator: Dark Fate",
                "Oct 23, 2019",
                "6.2",
                "Action, Science Fiction",
                "en",
                "Decades after Sarah Connor prevented Judgment Day, a lethal new Terminator is sent to eliminate the future leader of the resistance. In a fight to save mankind, battle-hardened Sarah Connor teams up with an unexpected ally and an enhanced super soldier to stop the deadliest Terminator yet.",
                "138.576"));

        movie.add(new MovieResponse("m09",
                "/db32LaOibwEliAmSL2jjDF6oDdj.jpg",
                "/jOzrELAzFxtMx2I4uDGHOotdfsS.jpg",
                "Star Wars: The Rise of Skywalker",
                "Dec 18, 2019",
                "6.5",
                "Action, Adventure, Science Fiction",
                "en",
                "The surviving Resistance faces the First Order once again as the journey of Rey, Finn and Poe Dameron continues. With the power and knowledge of generations behind them, the final battle begins.",
                "119.03"));

        movie.add(new MovieResponse("m10",
                "/7IiTTgloJzvGI1TAYymCfbfl3vT.jpg",
                "/TU9NIjwzjoKPwQHoHshkFcQUCG.jpg",
                "Parasite",
                "May 30, 2019",
                "8.6",
                "Comedy, Thriller, Drama",
                "en",
                "All unemployed, Ki-taek's family takes peculiar interest in the wealthy and glamorous Parks for their livelihood until they get entangled in an unexpected incident.",
                "106.013"));
        return movie;
    }

    public static ArrayList<ShowResponse> generateRemoteDummyShow() {
        ArrayList<ShowResponse> show = new ArrayList<>();

        show.add(new ShowResponse("s01",
                "/lHZ4xqGQlmyiFTOVtwnNpTcZgkd.jpg",
                "/q54k3tg5VjezBagGRtFamVqdY7L.jpg",
                "Insatiable",
                "Aug 10, 2018",
                "7.6",
                "Drama, Comedy",
                "en",
                "A bullied teenager turns to beauty pageants as a way to exact her revenge, with the help of a disgraced coach who soon realizes he's in over his head.",
                "754.632"));

        show.add(new ShowResponse("s02",
                "/jQNOzoiaIQWxJAx8OUighnvnhRA.jpg",
                "/gVVaukIifGJD78llZKgyT5FQbAe.jpg",
                "Thieves of the Wood",
                "Jan 02, 2020",
                "5.6",
                "Drama, Mystery",
                "en",
                "Charismatic highwayman Jan de Lichte leads the oppressed and downtrodden in a revolt against the corrupt aristocracy of 18th-century Belgium.",
                "468.515"));

        show.add(new ShowResponse("s03",
                "/gKG5QGz5Ngf8fgWpBsWtlg5L2SF.jpg",
                "/dKxkwAJfGuznW8Hu0mhaDJtna0n.jpg",
                "Arrow",
                "Oct 10, 2012",
                "5.9",
                "Crime, Drama, Mystery",
                "en",
                "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
                "292.791"));

        show.add(new ShowResponse("s04",
                "/qcr9bBY6MVeLzriKCmJOv1562uY.jpg",
                "/f5uNbUC76oowt5mt5J9QlqrIYQ6.jpg",
                "The Simpsons",
                "Dec 17, 1989",
                "7.2",
                "Animation, Comedy",
                "en",
                "Set in Springfield, the average American town, the show focuses on the antics and everyday adventures of the Simpson family; Homer, Marge, Bart, Lisa and Maggie, as well as a virtual cast of thousands. Since the beginning, the series has been a pop culture icon, attracting hundreds of celebrities to guest star. The show has also made name for itself in its fearless satirical take on politics, media and American life in general.",
                "164.056"));

        show.add(new ShowResponse("s05",
                "/nIlAKIrLKxOeoEnc0Urb65yNCp.jpg",
                "/mK286PAkhgLJqk5cO0BCmFLkNE7.jpg",
                "Star Trek: Picard",
                "Jan 23, 2020",
                "8.6",
                "Sci-Fi & Fantasy",
                "en",
                "Star Trek: Picard features Sir Patrick Stewart reprising his iconic role as Jean-Luc Picard, which he played for seven seasons on Star Trek: The Next Generation. Set twenty years after the events of Star Trek Nemesis, this series follow the now-retired Admiral Picard into the next chapter of his life.",
                "178.002"));

        show.add(new ShowResponse("s06",
                "/KoYWXbnYuS3b0GyQPkbuexlVK9.jpg",
                "/o9OKe3M06QMLOzTl3l6GStYtnE9.jpg",
                "Supernatural",
                "Sep 13, 2005",
                "7.5",
                "Drama, Mystery, Sci-Fi & Fantasy",
                "en",
                "When they were boys, Sam and Dean Winchester lost their mother to a mysterious and demonic supernatural force. Subsequently, their father raised them to be soldiers. He taught them about the paranormal evil that lives in the dark corners and on the back roads of America ... and he taught them how to kill it. Now, the Winchester brothers crisscross the country in their '67 Chevy Impala, battling every kind of supernatural threat they encounter along the way.",
                "160.463"));

        show.add(new ShowResponse("s07",
                "/qJdfO3ahgAMf2rcmhoqngjBBZW1.jpg",
                "/mzzHr6g1yvZ05Mc7hNj3tUdy2bM.jpg",
                "Rick and Morty",
                "Dec 02, 2013",
                "8.6",
                "Animation, Comedy, Sci-Fi & Fantasy",
                "en",
                "Rick is a mentally-unbalanced but scientifically-gifted old man who has recently reconnected with his family. He spends most of his time involving his young grandson Morty in dangerous, outlandish adventures throughout space and alternate universes. Compounded with Morty's already unstable family life, these events cause Morty much distress at home and school.",
                "154.306"));

        show.add(new ShowResponse("s08",
                "/cDDb7WA2i7cENhkEEjXEDrXGyNL.jpg",
                "/nfH8SZJVOxcBlFaqqtoqS5hHizG.jpg",
                "Doctor Who",
                "Mar 26, 2005",
                "7.0",
                "Drama, Sci-Fi & Fantasy",
                "en",
                "The Doctor is a Time Lord: a 900 year old alien with 2 hearts, part of a gifted civilization who mastered time travel. The Doctor saves planets for a living—more of a hobby actually, and the Doctor's very, very good at it.",
                "121.924"));

        show.add(new ShowResponse("s09",
                "/6t6r1VGQTTQecN4V0sZeqsmdU9g.jpg",
                "/kOvt2BOOwSAQCT8yo3pM3X2GXjh.jpg",
                "Law & Order: Special Victims Unit",
                "Sep 20, 1999",
                "6.5",
                "Crime, Drama",
                "en",
                "In the criminal justice system, sexually-based offenses are considered especially heinous. In New York City, the dedicated detectives who investigate these vicious felonies are members of an elite squad known as the Special Victims Unit. These are their stories.",
                "157.393"));

        show.add(new ShowResponse("s10",
                "/ff1zhqvwfS5HvRNcA5UFrH0PA2q.jpg",
                "/aq2yEMgRQBPfRkrO0Repo2qhUAT.jpg",
                "Vikings",
                "Mar 03, 2013",
                "7.5",
                "Drama",
                "en",
                "The adventures of Ragnar Lothbrok, the greatest hero of his age. The series tells the sagas of Ragnar's band of Viking brothers and his family, as he rises to become King of the Viking tribes. As well as being a fearless warrior, Ragnar embodies the Norse traditions of devotion to the gods. Legend has it that he was a direct descendant of Odin, the god of war and warriors.",
                "125.564"));

        return show;
    }
}
