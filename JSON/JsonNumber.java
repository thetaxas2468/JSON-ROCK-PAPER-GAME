package ex3;
public class JsonNumber implements JsonValue{
	Number k;
	public JsonNumber(CharScanner sc) {
		String s=new String();
		JsonSyntaxException error=new JsonSyntaxException();
		char index;
		boolean test;
		sc.peek();
		index=sc.peek();
		test=Character.isDigit(index);
		if(index=='-') {//checks if it start with - 
			s+=index;
			sc.next();
			if(sc.hasNext()) {
				index=sc.next();
				test=Character.isDigit(index);
				if(test) {//checks if it is digit and if it start with 0 and it do the work to make the number
					if(index=='0') {
						s+=index;
						if(!sc.hasNext()||sc.peek()==']'||sc.peek()=='}'||sc.peek()==','||sc.peek()==':') {
							k=Integer.parseInt(s);
							return;
						}
						else {
							index=sc.next();
							if(index!='.'&&index!='e'&&index!='E') {
								error.error();
							}
							else {
								if(index=='.') {//check if it has. so it is starting to be double
									s+=index;
									if(!sc.hasNext()) {
										error.error();
									}
									else {
										while(sc.hasNext()&&Character.isDigit(sc.peek())) {
											s+=sc.next();
										}
										if(!sc.hasNext()||sc.peek()==']'||sc.peek()=='}'||sc.peek()==','||sc.peek()==':') {
											k=Double.parseDouble(s);
											return;
										}
										index=sc.next();
										if(index!='E'&&index!='e') {//check if it dont conttaints e that is 10^after e
											error.error();
										}
										else {//if e or E
											s+=index;
											if(!sc.hasNext()) {
												error.error();
											}
											else {
												index=sc.next();
												if(index=='+'||index=='-') {//if it contatins + or -
													s+=index;
													if(!sc.hasNext()) {
														error.error();
													}
													else {
														while(sc.hasNext()&&Character.isDigit(sc.peek())){
															s+=sc.next();
														}
														if(!sc.hasNext()||sc.peek()==']'||sc.peek()=='}'||sc.peek()==','||sc.peek()==':') {
															k=Double.parseDouble(s);
															return;
														}
														if(sc.hasNext()) {
															error.error();
														}
													}
												}
												else {//if dont contain + or -
													s+=index;
													while(sc.hasNext()&&Character.isDigit(sc.peek())){
														s+=sc.next();
													}
													if(!sc.hasNext()||sc.peek()==']'||sc.peek()=='}'||sc.peek()==','||sc.peek()==':') {
														k=Double.parseDouble(s);
														return;
													}
													if(sc.hasNext()) {
														error.error();
													}
												}
											}
											
										}
									}
								}
								else {//it is e or E
									s+=index;
									if(!sc.hasNext()) {
										error.error();
									}
									else {
										index=sc.next();
										if(index=='+'||index=='-') {//checks + -
											s+=index;
											if(!sc.hasNext()) {
												error.error();
											}
											else {
												while(sc.hasNext()&&Character.isDigit(sc.peek())){
													s+=sc.next();
												}
												if(!sc.hasNext()||sc.peek()==']'||sc.peek()=='}'||sc.peek()==','||sc.peek()==':') {
													k=Double.parseDouble(s);
													return;
												}
												if(sc.hasNext()) {
													error.error();
												}
											}
										}
										else {//check with out - +
											s+=index;
											while(sc.hasNext()&&Character.isDigit(sc.peek())){
												s+=sc.next();
											}
											if(!sc.hasNext()||sc.peek()==']'||sc.peek()=='}'||sc.peek()==','||sc.peek()==':') {
												k=Double.parseDouble(s);
												return;
											}
											if(sc.hasNext()) {
												error.error();
											}
										}
									}
								}
							}
							
						}
					}
					else {//if not 0(0-9)//we are in while
						s+=index;
						while(sc.hasNext()&&Character.isDigit(sc.peek())) {
							s+=sc.next();
						}
						if(!sc.hasNext()||sc.peek()==']'||sc.peek()=='}'||sc.peek()==','||sc.peek()==':') {
							k=Integer.parseInt(s);
							return;
						}
						index=sc.next();
						if(index!='.'&&index!='e'&&index!='E') {//check if not e . or E and error else it has one of them
							error.error();
						}
						else {
							if(index=='.') {
								s+=index;
								if(!sc.hasNext()) {
									error.error();
								}
								else {
									while(sc.hasNext()&&Character.isDigit(sc.peek())) {
										s+=sc.next();
									}
									if(!sc.hasNext()||sc.peek()==']'||sc.peek()=='}'||sc.peek()==','||sc.peek()==':') {
										k=Double.parseDouble(s);
										return;
									}
									index=sc.next();
									if(index!='E'&&index!='e') {
										error.error();
									}
									else {//ife or E
										s+=index;
										if(!sc.hasNext()) {
											error.error();
										}
										else {
											index=sc.next();
											if(index=='+'||index=='-') {//checks + -
												s+=index;
												if(!sc.hasNext()) {
													error.error();
												}
												else {
													while(sc.hasNext()&&Character.isDigit(sc.peek())){
														s+=sc.next();
													}
													if(!sc.hasNext()||sc.peek()==']'||sc.peek()=='}'||sc.peek()==','||sc.peek()==':') {
														k=Double.parseDouble(s);
														return;
													}
													if(sc.hasNext()) {
														error.error();
													}
												}
											}
											else {// not + -
												s+=index;
												while(sc.hasNext()&&Character.isDigit(sc.peek())){
													s+=sc.next();
												}
												if(!sc.hasNext()||sc.peek()==']'||sc.peek()=='}'||sc.peek()==','||sc.peek()==':') {
													k=Double.parseDouble(s);
													return;
												}
												if(sc.hasNext()) {
													error.error();
												}
											}
										}
										
									}
								}
							}
							else {//it is e or E
								s+=index;
								if(!sc.hasNext()) {
									error.error();
								}
								else {
									index=sc.next();
									if(index=='+'||index=='-') {//if it has e not like before with out e it checks
										s+=index;
										if(!sc.hasNext()) {
											error.error();
										}
										else {
											while(sc.hasNext()&&Character.isDigit(sc.peek())){
												s+=sc.next();
											}
											if(!sc.hasNext()||sc.peek()==']'||sc.peek()=='}'||sc.peek()==','||sc.peek()==':') {
												Double q=Double.parseDouble(s);
												k=q.intValue();
												return;
											}
											if(sc.hasNext()) {
												error.error();
											}
										}
									}
									else {
										s+=index;
										while(sc.hasNext()&&Character.isDigit(sc.peek())){
											s+=sc.next();
										}
										if(!sc.hasNext()||sc.peek()==']'||sc.peek()=='}'||sc.peek()==','||sc.peek()==':') {
											Double q=Double.parseDouble(s);
											k=q.intValue();
											return;
										}
										if(sc.hasNext()) {
											error.error();
										}
									}
								}
							}
						}
					}
				}
				else {
					error.error();
				}
			}
			else {
				error.error();
			}
			
		}
		else if(test){//if not - and it is number
			if(sc.hasNext()) {
				index=sc.next();
				test=Character.isDigit(index);
				if(test) {//check the same thing as above but not - 
					if(index=='0') {
						s+=index;
						if(!sc.hasNext()||sc.peek()==']'||sc.peek()=='}'||sc.peek()==','||sc.peek()==':') {
							k=Integer.parseInt(s);
							return;
						}
						else {
							index=sc.next();
							if(index!='.'&&index!='e'&&index!='E') {
								error.error();
							}
							else {
								if(index=='.') {
									s+=index;
									if(!sc.hasNext()) {
										error.error();
									}
									else {
										while(sc.hasNext()&&Character.isDigit(sc.peek())) {
											s+=sc.next();
										}
										if(!sc.hasNext()||sc.peek()==']'||sc.peek()=='}'||sc.peek()==','||sc.peek()==':') {
											k=Double.parseDouble(s);
											return;
										}
										index=sc.next();
										if(index!='E'&&index!='e') {
											error.error();
										}
										else {//ife or E
											s+=index;
											if(!sc.hasNext()) {
												error.error();
											}
											else {
												index=sc.next();
												if(index=='+'||index=='-') {
													s+=index;
													if(!sc.hasNext()) {
														error.error();
													}
													else {
														while(sc.hasNext()&&Character.isDigit(sc.peek())){
															s+=sc.next();
														}
														if(!sc.hasNext()||sc.peek()==']'||sc.peek()=='}'||sc.peek()==','||sc.peek()==':') {
															k=Double.parseDouble(s);
															return;
														}
														if(sc.hasNext()) {
															error.error();
														}
													}
												}
												else {
													s+=index;
													while(sc.hasNext()&&Character.isDigit(sc.peek())){
														s+=sc.next();
													}
													if(!sc.hasNext()||sc.peek()==']'||sc.peek()=='}'||sc.peek()==','||sc.peek()==':') {
														k=Double.parseDouble(s);
														return;
													}
													if(sc.hasNext()) {
														error.error();
													}
												}
											}
											
										}
									}
								}
								else {//it is e or E
									s+=index;
									if(!sc.hasNext()) {
										error.error();
									}
									else {
										index=sc.next();
										if(index=='+'||index=='-') {
											s+=index;
											if(!sc.hasNext()) {
												error.error();
											}
											else {
												while(sc.hasNext()&&Character.isDigit(sc.peek())){
													s+=sc.next();
												}
												if(!sc.hasNext()||sc.peek()==']'||sc.peek()=='}'||sc.peek()==','||sc.peek()==':') {
													k=Double.parseDouble(s);
													return;
												}
												if(sc.hasNext()) {
													error.error();
												}
											}
										}
										else {
											s+=index;
											while(sc.hasNext()&&Character.isDigit(sc.peek())){
												s+=sc.next();
											}
											if(!sc.hasNext()||sc.peek()==']'||sc.peek()=='}'||sc.peek()==','||sc.peek()==':') {
												k=Double.parseDouble(s);
												return;
											}
											if(sc.hasNext()) {
												error.error();
											}
										}
									}
								}
							}
							
						}
					}
					else {//if not 0(0-9)//we are in while
						s+=index;
						while(sc.hasNext()&&Character.isDigit(sc.peek())) {
							s+=sc.next();
						}
						if(!sc.hasNext()||sc.peek()==']'||sc.peek()=='}'||sc.peek()==','||sc.peek()==':') {
							k=Integer.parseInt(s);
							return;
						}
						index=sc.next();
						if(index!='.'&&index!='e'&&index!='E') {
							error.error();
						}
						else {
							if(index=='.') {
								s+=index;
								if(!sc.hasNext()) {
									error.error();
								}
								else {
									while(sc.hasNext()&&Character.isDigit(sc.peek())) {
										s+=sc.next();
									}
									if(!sc.hasNext()||sc.peek()==']'||sc.peek()=='}'||sc.peek()==','||sc.peek()==':') {
										k=Double.parseDouble(s);
										return;
									}
									index=sc.next();
									if(index!='E'&&index!='e') {
										error.error();
									}
									else {//ife or E
										s+=index;
										if(!sc.hasNext()) {
											error.error();
										}
										else {
											index=sc.next();
											if(index=='+'||index=='-') {
												s+=index;
												if(!sc.hasNext()) {
													error.error();
												}
												else {
													while(sc.hasNext()&&Character.isDigit(sc.peek())){
														s+=sc.next();
													}
													if(!sc.hasNext()||sc.peek()==']'||sc.peek()=='}'||sc.peek()==','||sc.peek()==':') {
														k=Double.parseDouble(s);
														return;
													}
													if(sc.hasNext()) {
														error.error();
													}
												}
											}
											else {
												s+=index;
												while(sc.hasNext()&&Character.isDigit(sc.peek())){
													s+=sc.next();
												}
												if(!sc.hasNext()||sc.peek()==']'||sc.peek()=='}'||sc.peek()==','||sc.peek()==':') {
													k=Double.parseDouble(s);
													return;
												}
												if(sc.hasNext()) {
													error.error();
												}
											}
										}
										
									}
								}
							}
							else {//it is e or E
								s+=index;
								if(!sc.hasNext()) {
									error.error();
								}
								else {
									index=sc.next();
									if(index=='+'||index=='-') {
										s+=index;
										if(!sc.hasNext()) {
											error.error();
										}
										else {
											while(sc.hasNext()&&Character.isDigit(sc.peek())){
												s+=sc.next();
											}
											if(!sc.hasNext()||sc.peek()==']'||sc.peek()=='}'||sc.peek()==','||sc.peek()==':') {
												Double q=Double.parseDouble(s);
												k=q.intValue();
												return;
											}
											if(sc.hasNext()) {
												error.error();
											}
										}
									}
									else {
										s+=index;
										while(sc.hasNext()&&Character.isDigit(sc.peek())){
											s+=sc.next();
										}
										if(!sc.hasNext()||sc.peek()==']'||sc.peek()=='}'||sc.peek()==','||sc.peek()==':') {
											Double q=Double.parseDouble(s);
											k=q.intValue();
											return;
										}
										if(sc.hasNext()) {
											error.error();
										}
									}
								}
							}
						}
					}
				}
				else {
					error.error();
				}
			}
		}
		else {
			error.error();
		}
	}
		
	@Override
	public JsonValue get(int i) {//cant get int i from number
		JsonQueryException error=new JsonQueryException();
		error.error();
		return null;
	}
	@Override
	public JsonValue get(String s) {//error cant get string from number
		JsonQueryException error=new JsonQueryException();
		error.error();
		return null;
	}
	@Override
	public String toString() {
		return  k+"";
	}

}
	
