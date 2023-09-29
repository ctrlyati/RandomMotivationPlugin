package app.ctrlyati.plugin.motivate.randommotivation.service

import com.intellij.openapi.components.*
import com.intellij.util.xmlb.XmlSerializerUtil


@State(
    name = "MainService",
    storages = [ Storage("randommotivation.xml") ]
)
class MainService : PersistentStateComponent<MainService> {
    companion object {
        @JvmStatic
        fun getInstance(): MainService {
            return service<MainService>()
        }
    }

    val quotes: List<String>
        get() = _quotes

    fun add(quote: String) {
        _quotes.add(quote)
    }

    fun set(quotes: List<String>) {
        _quotes = quotes.toMutableList()
    }

    private var _quotes: MutableList<String> = mutableListOf(
        "“The best and most beautiful things in the world cannot be seen or even touched - they must be felt with the heart.” ― Helen Keller",
        "“If you can dream it, you can do it.” ― Walt Disney",
        "“The only way to do great work is to love what you do.” ― Steve Jobs",
        "“Don't let yesterday take up too much of today.” ― Will Rogers",
        "“It's not whether you get knocked down, it's whether you get back up.” ― Vince Lombardi",
        "“The only person you are destined to become is the person you decide to be.” ― Ralph Waldo Emerson",
        "“Believe you can and you're halfway there.” ― Theodore Roosevelt",
        "“The best revenge is massive success.” ― Frank Sinatra",
        "“Don't be afraid to fail. It's not the end of the world, and in many ways, it's the first step toward learning something and getting better at it.” ― Jon Hamm",
        "“The only thing that stands between you and your goal is the story you keep telling yourself about why you can't achieve it.” ― Wayne Dyer",
        "“If you don't like something, change it. If you can't change it, change your attitude.” ― Maya Angelou",
        "“You are braver than you believe, stronger than you seem, and smarter than you think.” ― A.A. Milne",
        "“The only limit to our realization of tomorrow will be our doubts of today.” ― Franklin D. Roosevelt",
        "“The secret of getting ahead is getting started.” ― Mark Twain",
        "“Don't be afraid to give up the good to go for the great.” ― John D. Rockefeller",
        "“Never let the fear of striking out keep you from playing the game.” ― Babe Ruth",
        "“The only way to do great work is to love what you do.” ― Steve Jobs",
        "“The future belongs to those who believe in the beauty of their dreams.” ― Eleanor Roosevelt",
        "“Life is too short to be anything but happy.” ― Bruce Lee",
        "“The only way to limit the amount of joy you have is to limit the amount of love you give.” ― Wayne Dyer",
        "“The best way to predict the future is to create it.” ― Peter Drucker",
        "“You can't wait for inspiration. You have to go after it with a club.” ― Jack London"
    )

    override fun getState(): MainService {
        return this
    }

    override fun loadState(state: MainService) {
        _quotes = state.quotes.toMutableList()
    }
}