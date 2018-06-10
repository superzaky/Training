package service;

// This forces every solution class to implement a common interface,
// which is helpful for unit testing like in the PTest implementation.
public interface Solution {
    public String run();
}
