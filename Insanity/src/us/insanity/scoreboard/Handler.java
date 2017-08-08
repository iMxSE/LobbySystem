package us.insanity.scoreboard;

import us.insanity.*;

public class Handler
{
    private Main plugin;
    
    public Handler(final Main plugin) {
        this.plugin = plugin;
    }
    
    public void enable() {
    }
    
    public void disable() {
    }
    
    public Main getInstance() {
        return this.plugin;
    }
}