package model;

public class Expense {
    private int id;
    private String description;
    private double amount;
    private String category;
    private String date;

    public Expense(int id, String description, double amount, String category, String date) {
        this.id = id;
        this.description = description;
        this.amount = amount;
        this.category = category;
        this.date = date;
    }

    public Expense(String description, double amount, String category, String date) {
        this(0, description, amount, category, date);
    }

    // Getters and setters

    public int getId() { return id; }
    public String getDescription() { return description; }
    public double getAmount() { return amount; }
    public String getCategory() { return category; }
    public String getDate() { return date; }

    public void setId(int id) { this.id = id; }
}
