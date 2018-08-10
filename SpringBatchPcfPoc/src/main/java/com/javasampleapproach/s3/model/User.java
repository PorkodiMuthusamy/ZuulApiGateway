package com.javasampleapproach.s3.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="User")
public class User{
	@Id
	private String firstname;


	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getSchool() {
		return school;
	}

	public void setSchool(String school) {
		this.school = school;
	}

	public String getRollnumber() {
		return rollnumber;
	}

	public void setRollnumber(String rollnumber) {
		this.rollnumber = rollnumber;
	}

	private String lastname;
	private String school;
	private String rollnumber;
	private String year;
	private String credit;
	private String mark;
	private String cheat;
	private String height;
	private String weight;
	private String obesity;
	private String length;
	private String score;
	private String runs;
	private String career;
	private String wanttobe;
	private String mistake;
	private String luck;
	private String love;
	private String fear;

	private String flex1;
	public String getFlex1() {
		return flex1;
	}

	public void setFlex1(String flex1) {
		this.flex1 = flex1;
	}

	public String getFlex2() {
		return flex2;
	}

	public void setFlex2(String flex2) {
		this.flex2 = flex2;
	}

	public String getFlex3() {
		return flex3;
	}

	public void setFlex3(String flex3) {
		this.flex3 = flex3;
	}

	public String getFlex4() {
		return flex4;
	}

	public void setFlex4(String flex4) {
		this.flex4 = flex4;
	}

	public String getFlex5() {
		return flex5;
	}

	public void setFlex5(String flex5) {
		this.flex5 = flex5;
	}

	public String getFlex6() {
		return flex6;
	}

	public void setFlex6(String flex6) {
		this.flex6 = flex6;
	}

	public String getFlex7() {
		return flex7;
	}

	public void setFlex7(String flex7) {
		this.flex7 = flex7;
	}

	public String getFlex8() {
		return flex8;
	}

	public void setFlex8(String flex8) {
		this.flex8 = flex8;
	}

	public String getFlex9() {
		return flex9;
	}

	public void setFlex9(String flex9) {
		this.flex9 = flex9;
	}

	public String getFlex10() {
		return flex10;
	}

	public void setFlex10(String flex10) {
		this.flex10 = flex10;
	}

	public String getFlex11() {
		return flex11;
	}

	public void setFlex11(String flex11) {
		this.flex11 = flex11;
	}

	public String getFlex12() {
		return flex12;
	}

	public void setFlex12(String flex12) {
		this.flex12 = flex12;
	}

	public String getFlex13() {
		return flex13;
	}

	public void setFlex13(String flex13) {
		this.flex13 = flex13;
	}

	public String getFlex14() {
		return flex14;
	}

	public void setFlex14(String flex14) {
		this.flex14 = flex14;
	}

	public String getFlex15() {
		return flex15;
	}

	public void setFlex15(String flex15) {
		this.flex15 = flex15;
	}

	public String getFlex16() {
		return flex16;
	}

	public void setFlex16(String flex16) {
		this.flex16 = flex16;
	}

	public String getFlex17() {
		return flex17;
	}

	public void setFlex17(String flex17) {
		this.flex17 = flex17;
	}

	public String getFlex18() {
		return flex18;
	}

	public void setFlex18(String flex18) {
		this.flex18 = flex18;
	}

	public String getFlex19() {
		return flex19;
	}

	public void setFlex19(String flex19) {
		this.flex19 = flex19;
	}

	public String getFlex20() {
		return flex20;
	}

	public void setFlex20(String flex20) {
		this.flex20 = flex20;
	}

	private String flex2;
	private String flex3;
	private String flex4;
	private String flex5;
	private String flex6;
	private String flex7;
	private String flex8;
	private String flex9;
	private String flex10;
	private String flex11;
	private String flex12;
	private String flex13;
	private String flex14;
	private String flex15;
	private String flex16;
	private String flex17;
	private String flex18;
	private String flex19;
	private String flex20;
	


	public String getYear(){
		return year;
	}

	public void setYear(String year){
		this.year=year;
	}

	public String getCredit(){
		return credit;
	}

	public void setCredit(String credit){
		this.credit=credit;
	}

	public String getMark(){
		return mark;
	}

	public void setMark(String mark){
		this.mark=mark;
	}

	public String getCheat(){
		return cheat;
	}

	public void setCheat(String cheat){
		this.cheat=cheat;
	}

	public String getHeight(){
		return height;
	}

	public void setHeight(String height){
		this.height=height;
	}

	public String getWeight(){
		return weight;
	}

	public void setWeight(String weight){
		this.weight=weight;
	}

	public String getObesity(){
		return obesity;
	}

	public void setObesity(String obesity){
		this.obesity=obesity;
	}

	public String getLength(){
		return length;
	}

	public void setLength(String length){
		this.length=length;
	}

	public String getScore(){
		return score;
	}

	public void setScore(String score){
		this.score=score;
	}

	public String getRuns(){
		return runs;
	}

	public void setRuns(String runs){
		this.runs=runs;
	}

	public String getCareer(){
		return career;
	}

	public void setCareer(String career){
		this.career=career;
	}

	public String getWanttobe(){
		return wanttobe;
	}

	public void setWanttobe(String wanttobe){
		this.wanttobe=wanttobe;
	}

	public String getMistake(){
		return mistake;
	}

	public void setMistake(String mistake){
		this.mistake=mistake;
	}

	public String getLuck(){
		return luck;
	}

	public void setLuck(String luck){
		this.luck=luck;
	}

	public String getLove(){
		return love;
	}

	public void setLove(String love){
		this.love=love;
	}

	public String getFear(){
		return fear;
	}

	public void setFear(String fear){
		this.fear=fear;
	}
}